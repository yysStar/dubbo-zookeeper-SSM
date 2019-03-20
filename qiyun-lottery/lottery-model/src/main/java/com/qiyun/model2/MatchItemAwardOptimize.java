package com.qiyun.model2;


import com.qiyun.model.MatchItem;
;
import com.qiyun.model.SportteryOption;
import com.qiyun.tools.DateTools;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatchItemAwardOptimize extends MatchItem implements Serializable {

    /**
     * 主队
     */
    private String home;

    /**
     * 客队
     */
    private String guest;

    /**
     * 客队
     */


    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }


    public String getWeekStr() {
        Date time = DateTools.StringToDate(getIntTime() + "", "yyyyMMdd");
        return DateTools.getWeekStr(time);
    }

    public String getLineIDText() {
        String lineId = getLineId().toString();
        for (int i = lineId.length(); i < 3; i++) {
            lineId = "0" + lineId;
        }
        return lineId;
    }


    @Override
    public MatchItemAwardOptimize cloneItem() {
        MatchItemAwardOptimize item = new MatchItemAwardOptimize();
        item.setIntTime(this.getIntTime());
        item.setLineId(this.getLineId());
        List<SportteryOption> tempOptionList = this.getOptions();
        List<SportteryOption> optionList = new ArrayList<SportteryOption>();
        for (SportteryOption option : tempOptionList) {
            optionList.add(option);
        }
        item.setOptions(optionList);
        item.setShedan(this.isShedan());
        item.setGuest(this.getGuest());
        item.setHome(this.getHome());
        return item;
    }


}
