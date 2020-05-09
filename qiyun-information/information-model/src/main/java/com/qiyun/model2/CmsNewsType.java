package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CmsNewsType {
    private Integer id;

    //上级ID
    private Integer parentId;

    //名称
    private String name;

    //关键词
    private String keyword;

    //标题
    private String title;

    //描述
    private String description;

    //副标题
    private String subheadName;

    //是否有下级类型  true为有  false为没有
    private boolean subordinate;

}