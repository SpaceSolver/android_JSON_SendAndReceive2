# android_JSON_SendAndReceive2
POSTに対応するアプリ

## POSTリスエスト　実装方法

```
// URL  
String url = "http://10.0.2.2:8088";  

 // リクエストパラメータ  
 Map<String, String> params = new HashMap();  
 params.put("num", "1");  
 params.put("name", "2");  
 JSONObject parameters = new JSONObject(params);  

mQueue.add(new JsonObjectRequest(Request.Method.POST, url, parameters,・・・))  
```
Request.Method : POSTを設定する。  
url            : 接続するサイトのURL  ※今回はAndroidEMU宛て
parameters     : 設定したい値をここに記載（リクエストボディに設定される）  

