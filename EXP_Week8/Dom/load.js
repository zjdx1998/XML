//检测系统支持的XMLDom方式
function E_getControlPrefix() {
　　var prefixes = ["MSXML2", "Microsoft", "@Microsoft", "MSXML", "MSXML3"];
　　var o, o2;
　　for (var i = 0; i < prefixes.length; i++) {
　　　　try {
　　　　　　// try to create the objects
　　　　　　o = new ActiveXObject(prefixes[i] + ".XmlHttp");
　　　　　　o2 = new ActiveXObject(prefixes[i] + ".XmlDom");
　　　　　　return E_getControlPrefix.prefix = prefixes[i];
　　　　}
　　　　catch (ex) { };
　　　　}
　　}
//创建xmldom对象
function loadXmlFile(xmlFile) {
　　var xmlDom = null;
　　try{
　　　　if (window.ActiveXObject) { //支持IE浏览器，可跨域
　　　　　　xmlDom = new ActiveXObject(E_getControlPrefix() + ".XMLDOM");
　　　　　　//xmlDom.loadXML(xmlFile);//如果用的是XML字符串
　　　　　　xmlDom.async = false;
　　　　　　xmlDom.loadXML(xmlFile); //如果用的是xml文件。
　　　　　　return xmlDom;
　　　　} else if (document.implementation && document.implementation.createDocument) { //支持火狐浏览器，可跨域
　　　　　　xmlDom = document.implementation.createDocument("", "", null);
　　　　　　//xmlDom.async = false;
　　　　　　xmlDom.load(xmlFile);
　　　　　　return xmlDom;
　　　　}
　　}
　　catch (ex) {}

　　try{
　　　　//xmlhttp方式，支持火狐、chrome、oprea等浏览器，但不可跨域
　　　　var xmlhttp = new window.XMLHttpRequest();
　　　　xmlhttp.open("GET", xmlFile, false);
　　　　xmlhttp.send(null);
　　　　if (xmlhttp.status == 200) {
　　　　　　xmlDom = xmlhttp.responseXML;
　　　　}
　　　　else {
　　　　　　//传入的是XML字符串而非XML地址时非IE浏览器处理
　　　　　　var parseXml = new DOMParser();
　　　　　　var xmlDom = parseXml.parseFromString(xmlFile, "text/xml");
　　　　}
　　}
　　catch (ex) {
　　　　//传入的是XML字符串而非XML地址时非IE浏览器处理
　　　　var parseXml = new DOMParser();
　　　　var xmlDom = parseXml.parseFromString(xmlFile, "text/xml");
　　}
　　return xmlDom;
}