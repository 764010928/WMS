package crazysheep.io.scanner.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 帮助快速创建{@link java.util.Map}
 *
 * Created by yang.li on 2016/12/3.
 */
public class MapCreator {

    private static final HashMap EMPTY_MAP = new HashMap();

    public static <K, V> HashMap<K, V> empty() {
        return (HashMap<K, V>) EMPTY_MAP;
    }

    /**
     * 快速创建一个{@link Map}
     * */
    public static Map<String, String> build(String... args) {
        if (args == null || args.length % 2 != 0) {
            throw new IllegalArgumentException(
                    String.format("-MapCreator.build()-, 参数%s非法", Arrays.toString(args)));
        }

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            map.put(args[i], args[i + 1]);
        }
        return map;
    }
}
