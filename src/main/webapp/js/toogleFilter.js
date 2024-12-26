window.addEventListener('load', function() {
    // 获取当前页面的URL
    var currentUrl = window.location.href;

    // 定义你想要匹配的特定URL或URL模式
    var targetUrlPattern = 'http://localhost:8080/mainForm';

    // 检查当前URL是否与目标URL匹配
    if (currentUrl === targetUrlPattern || currentUrl.includes(targetUrlPattern)) {
        // 如果匹配，则显示div
        document.getElementById('filter-container').style.display = 'block';
    } else {
        // 否则隐藏div
        document.getElementById('filter-container').style.display = 'none';
    }
});