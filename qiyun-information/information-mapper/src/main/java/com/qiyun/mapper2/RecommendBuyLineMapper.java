package com.qiyun.mapper2;

import com.qiyun.dto.RecommendPlanDTO;
import com.qiyun.model2.RecommendBuyLine;
import com.qiyun.model2.RecommendBuyLineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendBuyLineMapper {

    List<RecommendPlanDTO> getBuyList( @Param("account") String account, @Param("type") Integer type);

    int deleteByPrimaryKey(Integer id);

    int insert(RecommendBuyLine record);

    int insertSelective(RecommendBuyLine record);

    List<RecommendBuyLine> selectByExample(RecommendBuyLineExample example);

    RecommendBuyLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendBuyLine record);

    int updateByPrimaryKey(RecommendBuyLine record);

    RecommendBuyLine selectByAccountAndPlanId(@Param("account") String account,@Param("planId") int planId);

    List<RecommendBuyLine> selectByPlanId(Integer planId);
}