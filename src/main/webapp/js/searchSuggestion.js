const keyword = document.getElementById('keyword');
const $searchSuggestionContent = $('#search-suggestion-content');
const searchSuggestion = document.getElementById('search-suggestion');

//动态内容在原本并不存在
//利用事件冒泡机制
//在其静态的父组件上监听事件
document.getElementById('search-suggestion-content').addEventListener('click', function (evt) {
    //在HTML中的data-product-id
    //在JS中自动转为小驼峰 productId;
    let productId = evt.target.dataset.productId;
    //跳转前清空数据 这样回退的时候就不会显示 搜索提示
    keyword.value = '';
    $searchSuggestionContent.html('');
    $searchSuggestionContent.hide();

    window.location.href = `http://localhost:8080/productForm?productId=${productId}`;
})

keyword.addEventListener('keyup', function () {
    const keywordValue = keyword.value;
    //保证在清空输入框的时候不展示搜索提示
    if (keywordValue !== null && keywordValue !== '' && keywordValue.length !== 0) {
        /*进行ajax请求*/
        $.ajax(
            {
                type: 'GET',
                url: 'http://localhost:8080/searchSuggestion?keyword=' + keywordValue,
                success: function (data) {
                    $searchSuggestionContent.html('');
                    for (let d of data) {
                        let id = d.categoryId;
                        let name = d.name;
                        let productId = d.productId;
                        $searchSuggestionContent.append(`<li data-product-id="${productId}" class="dynamic">${id}: ${name}</li>`);
                    }
                    $searchSuggestionContent.show();
                },
                error: function (errorMsg) {
                    console.log('error')
                    console.log(errorMsg);
                }
            }
        );
    } else {
        $searchSuggestionContent.hide();
    }
});

searchSuggestion.addEventListener('mouseleave', function () {
    $searchSuggestionContent.hide();
})