var items = [
    {"id_item": 1,"name_item": "Pastilha", "quantity_item": 15,"description_item": "sabor menta"},
    {"id_item": 2,"name_item": "Chocolate", "quantity_item": 400,"description_item": "Nestle"},
    {"id_item": 3,"name_item": "Maçã", "quantity_item": 15,"description_item": "Alcobaça"},
    {"id_item": 4,"name_item": "Amaciador", "quantity_item": 40,"description_item": "H&S"},
    {"id_item": 5,"name_item": "Lava-tudo", "quantity_item": 150,"description_item": "Made in China!"},
];
    
    function showTableItems() {
        let strHtml = `<thead><tr><th>Id</th><th>Title</th><th>Quantity</th><th>Description</th></tr></thead>`;
        strHtml += `<tbody>`;
        let i = 1;
        for (const item of items) {
            strHtml += `<tr><td>${item.id_item}</td><td>${item.name_item}</td><td>${item.quantity_item}</td><td>${item.description_item}</td></tr>`;
            i++;
        }
        strHtml += `</tbody>`;
        document.getElementById("tableItems").innerHTML = strHtml;
    }



var items = [
        {"id_item": 1,"name_item": "Pastilha", "quantity_item": 15,"description_item": "sabor menta"},
        {"id_item": 2,"name_item": "Chocolate", "quantity_item": 400,"description_item": "Nestle"},
        {"id_item": 3,"name_item": "Maçã", "quantity_item": 15,"description_item": "Alcobaça"},
        {"id_item": 4,"name_item": "Amaciador", "quantity_item": 40,"description_item": "H&S"},
        {"id_item": 5,"name_item": "Lava-tudo", "quantity_item": 150,"description_item": "Made in China!"},
    ];

    function showTableItemsInStock() {
        let strHtml = `<thead><tr><th>Id</th><th>Title</th><th>Quantity</th><th>Description</th></tr></thead>`;
        strHtml += `<tbody>`;
        let i = 1;
        for (const item of items) {
            strHtml += `<tr><td>${item.id_item}</td><td>${item.name_item}</td><td>${item.quantity_item}</td><td>${item.description_item}</td></tr>`;
            i++;
        }
        strHtml += `</tbody>`;
        document.getElementById("tableItemsinstock").innerHTML = strHtml;
    }