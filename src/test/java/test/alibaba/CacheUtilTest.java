package test.alibaba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheUtilTest {

    CacheUtil cacheUtil = new CacheUtil();

    @Test
    void test() {
        Long productId = (long)1000;
        Product product = new Product(productId, "test1");
        cacheUtil.put(productId, product);

        // 获取已经存在的
        System.out.println(cacheUtil.get(productId).getProductName());
        // 获取缓存中没有的
        System.out.println(cacheUtil.get((long)100).getProductName());

    }
}