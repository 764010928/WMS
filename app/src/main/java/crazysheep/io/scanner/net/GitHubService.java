package crazysheep.io.scanner.net;

import crazysheep.io.scanner.net.Entity.GistEntity;
import crazysheep.io.scanner.utils.MapCreator;

/**
 * github的service，测试网络框架
 *
 * Created by yang.li on 2016/12/3.
 */
public class GitHubService implements ApiService {

    private static final String GIST = "/gists/%s";

    /**
     * 请求单个的gist
     * */
    public String gist(String gistId, Callback<GistEntity> callback) {
        return HttpClient.getInstance()
                .get(String.format(GIST, gistId),
                        MapCreator.<String, String>empty(), GistEntity.class, callback);
    }
}
