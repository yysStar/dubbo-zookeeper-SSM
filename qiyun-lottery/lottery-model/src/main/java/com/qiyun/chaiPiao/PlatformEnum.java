package com.qiyun.chaiPiao;

public enum PlatformEnum {

//	BASKETBALL(new MatchListByZch(), "http://b2b.zch168.com/201.xml", "http://www.310win.com/jingcailanqiu/kaijiang_jclq_all.html","http://www.310win.com/jingcailanqiu/kaijiang_jclq_all.html","http://info.sporttery.cn/basketball/match_list.php","http://www.310win.com/jingcailanqiu/kaijiang_jclq_all_2.html"),
//	FOOTBALL(new FootballMatchList(), "http://b2b.zch168.com/200.xml", "http://info.sporttery.cn/football/match_result.php","http://www.310win.com/jingcaizuqiu/kaijiang_jc_all.html","http://info.sporttery.cn/football/match_list.php","");
	BASKETBALL(new MatchList(), "http://i.sporttery.cn/odds_calculator/get_odds?i_format=json&i_callback=getData&poolcode[]=mnl&poolcode[]=wnm&poolcode[]=hdc&poolcode[]=hilo&_=", "http://www.310win.com/jingcailanqiu/kaijiang_jclq_all.html","http://www.310win.com/jingcailanqiu/kaijiang_jclq_all.html","http://info.sporttery.cn/basketball/match_list.php","http://www.310win.com/jingcailanqiu/kaijiang_jclq_all_2.html"),
	FOOTBALL(new FootballMatchList(), "http://i.sporttery.cn/odds_calculator/get_odds?i_format=json&i_callback=getData&poolcode[]=had&poolcode[]=hhad&poolcode[]=crs&poolcode[]=ttg&poolcode[]=hafu&_=", "http://info.sporttery.cn/football/match_result.php","http://www.310win.com/jingcaizuqiu/kaijiang_jc_all.html","http://info.sporttery.cn/football/match_list.php","");
	
	private MatchInterface matchInterface;
	private String resultUrl;
	private String matchUrl;
	private String resultSingleAwardUrl;
	private String statusUrl;
	private String resultPassUrl;//获取过关的大小盘/让分

	private PlatformEnum(MatchInterface matchInterface, String matchUrl, String resultUrl,String resultSingleAwardUrl,String statusUrl,String resultPassUrl) {
		this.matchInterface = matchInterface;
		this.resultUrl = resultUrl;
		this.matchUrl = matchUrl;
		this.resultSingleAwardUrl=resultSingleAwardUrl;
		this.statusUrl=statusUrl;
		this.resultPassUrl=resultPassUrl;
	}

	public MatchInterface getMatchInterface() {
		return matchInterface;
	}

	public void setMatchInterface(MatchInterface matchInterface) {
		this.matchInterface = matchInterface;
	}

	public static PlatformEnum valueOfName(String name) {
		for (PlatformEnum p : PlatformEnum.values()) {
			if (p.name().equals(name)) {
				return p;
			}
		}
		return null;
	}

	public String getMatchUrl() {
		return matchUrl;
	}

	public void setMatchUrl(String matchUrl) {
		this.matchUrl = matchUrl;
	}

	public String getResultUrl() {
		return resultUrl;
	}

	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}

	public String getStatusUrl() {
		return statusUrl;
	}

	public void setStatusUrl(String statusUrl) {
		this.statusUrl = statusUrl;
	}

	public String getResultSingleAwardUrl() {
		return resultSingleAwardUrl;
	}

	public void setResultSingleAwardUrl(String resultSingleAwardUrl) {
		this.resultSingleAwardUrl = resultSingleAwardUrl;
	}

	public String getResultPassUrl() {
		return resultPassUrl;
	}

	public void setResultPassUrl(String resultPassUrl) {
		this.resultPassUrl = resultPassUrl;
	}
	
}
