window.addEventListener('load', function() {
    const $cartPreview = $('#cart-preview')
    $.ajax({
        type:'get',
        url:'http://localhost:8080/getCartData',
        success(data) {
            console.log(data)
            let allCartItems = data.allCartItems;
            for (let a of allCartItems) {
                let html = `<div class="cart-entry"><div>${a.item.descn}</div><div>itemId: ${a.item.itemId}</div><div>listPrice: <span style="font-weight: bold">$${a.item.listPrice}</span></div><div>quantity: ${a.quantity}</div><div>total: <span style="font-weight: bold">$${a.total}</span></div></div>`

                $cartPreview.append(html)
            }
            $cartPreview.append(`<div class="cart-entry">Total: $${data.subTotal}</div>`)
        },
        error(errorMsg) {
            console.log(errorMsg)
        },
    })
});