package com.qiyun.serviceImpl;

import com.qiyun.mapper2.CmsNews2Mapper;
import com.qiyun.mapper2.CmsNewsTypeMapper;
import com.qiyun.model2.CmsNewsType;
import com.qiyun.model2.CmsNewsTypeExample;
import com.qiyun.service.CmsNewsTypeService;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CmsNewsTypeServiceImpl implements CmsNewsTypeService {

    @Autowired
    private CmsNewsTypeMapper cmsNewsTypeMapper;

    public Map<String, Object> getNewsList(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if(id==null){
                id =0;
            }
            CmsNewsTypeExample cmsNewsTypeExample = new CmsNewsTypeExample();
            cmsNewsTypeExample.createCriteria().andParentIdEqualTo(id);
            List<CmsNewsType> cmsNewsTypes = cmsNewsTypeMapper.selectByExample(cmsNewsTypeExample);
            for (CmsNewsType cmsNewsType:cmsNewsTypes) {
                Integer id2 = cmsNewsType.getId();
                CmsNewsTypeExample cmsNewsTypeExample2 = new CmsNewsTypeExample();
                cmsNewsTypeExample.createCriteria().andParentIdEqualTo(id2);
                List<CmsNewsType> cmsNewsTypes2 = cmsNewsTypeMapper.selectByExample(cmsNewsTypeExample);
                //判断是否存在下级菜单
                if(cmsNewsTypes2.size()>=1){
                    cmsNewsType.setSubordinate(true);
                }else{
                    cmsNewsType.setSubordinate(false);
                }
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, cmsNewsTypes);
            return map;
        } catch (Exception e) {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取竞彩足球出错");
            return map;
        }

    }

}
