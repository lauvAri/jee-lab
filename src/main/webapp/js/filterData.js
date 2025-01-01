const main = document.getElementById('Main')
const $filteredDataContainer= $('#filtered-data-container')
const categoryFilter = document.getElementById('category-filter')
const productFilter = document.getElementById('product-filter')
categoryFilter.addEventListener('change', function() {
    $.ajax({
        type: "get",
        url:'http://localhost:8080/filterDataByCategory?category=' + categoryFilter.value,
        success(data){
            //更新productFilter
            productFilter.innerHTML = ''
            let defaultOption = document.createElement('option')
            defaultOption.value = ''
            defaultOption.text = 'Choose Product'
            defaultOption.selected = true
            defaultOption.disabled = true
            productFilter.appendChild(defaultOption)
            for (d of data) {
                let option = document.createElement('option')
                option.value = d.productId
                option.text = `${d.name}: ${d.productId}`
                productFilter.appendChild(option)
            }
        },
        error(errorMsg) {
            console.log(errorMsg)
        }
    })
})
productFilter.addEventListener('change', function() {
    $.ajax({
        type:'get',
        url:'http://localhost:8080/filterDataByProduct?product=' + productFilter.value,
        success(data) {
            //更新页面
            main.innerHTML = ''
            main.style.display = 'none'
            $filteredDataContainer.html('')
            for (let d of data) {
                let html = `
                                <div id="${d.itemId}" class="filtered-data-entry" 
                                        title=" ${d.attribute1}\n name: ${d.product.name}\n list price: ${d.listPrice}\n item ID: ${d.itemId}">
                                    ${d.product.description}
                                    <div>${d.product.name} $ ${d.listPrice}</div>
                                    <button class="add-to-item-btn" data-item-id="${d.itemId}">Add to cart</button>
                                </div>
                                `
                $filteredDataContainer.append(html)
            }
            console.log(data)
        },
        error(errorMsg) {
            console.log(errorMsg)
        }
    })
})