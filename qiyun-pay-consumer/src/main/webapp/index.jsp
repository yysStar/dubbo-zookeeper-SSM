<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<body>
<h2>pay consumer</h2>
<form action="http://118.89.46.160/zhitong-api/services/wap/pay"
      method="post">
    <ul>
        <li>
            <input type="text" name="order_id" value='20180727163356598915' />
            <input type="text" name="merchant_id" value='207507139541995520' />
            <input type="text" name="biz_code" value='1004' />
            <input type="text" name="order_amt" value='1' />
            <input type="text" name="return_url" value='https://m.qiyun88.cn/recharge' />
            <input type="text" name="bg_url" value='https://pay.api.qiyun88.cn/yinFu/zfbWapAccept' />
            <input type="text" name="sign" value='FFA2B26BD9EB0062D11A8D5F20F6199A' />
            <button name="next_btn" class="btn" type="submit" id="next_btn">支付宝支付</button>
        </li>
    </ul>
</form>
</body>
</html>
