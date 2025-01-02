const filteredDataContainer = document.getElementById('filtered-data-container');
filteredDataContainer.addEventListener('click', function (e){
    const target = e.target;
    console.log('target: ' + target, target.dataset.itemId);
    const workingItemId = target.dataset.itemId
    const xhr = new XMLHttpRequest()
    xhr.open('GET', 'http://localhost:8080/api/addItemToCart?workingItemId='+workingItemId)
    xhr.onreadystatechange = function () {
        if (xhr.readyState !== 4) return;
        if (xhr.status === 200 || xhr.status === 304) {
            console.log(xhr.responseText);
            if (xhr.responseText === 'true') {
                $.ajax({
                    type:'GET',
                    url:'http://localhost:8080/getCartData',
                    success(data) {
                        const $cartPreview = $('#cart-preview')
                        const allCartItems = data.allCartItems;
                        $cartPreview.html('')
                        //$cartPreview.append('My Cart')
                        for (let a of allCartItems) {
                            let html = `<div class="cart-entry"><div>itemId: ${a.item.itemId}</div><div>listPrice: ${a.item.listPrice}</div><div>quantity: ${a.quantity}</div><div>total: ${a.total}</div></div>`

                            $cartPreview.append(html)
                        }
                        $cartPreview.append(`<div class="cart-entry">Total: $${data.subTotal}</div>`)
                    },
                    error(errorMsg){
                        console.log(errorMsg)
                    }
                })
            } else {
                window.location.href = 'http://localhost:8080/loginView';
            }
        } else {
            console.log('error when update cart preview');
        }
    }
    xhr.send();
})