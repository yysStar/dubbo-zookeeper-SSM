package com.qiyun.chaiPiao;


import com.qiyun.grabber.model.AbstractAward;

import java.util.List;

public interface AwardInterface<X extends AbstractAward> {
	List<X> getSingleAwardList(String html);

	List<X> getPassAwardList(String html);
}
