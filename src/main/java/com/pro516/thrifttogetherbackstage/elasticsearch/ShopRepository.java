package com.pro516.thrifttogetherbackstage.elasticsearch;

import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 13:03
 */
public interface ShopRepository extends ElasticsearchRepository<SimpleShopVO, Integer> {
}
