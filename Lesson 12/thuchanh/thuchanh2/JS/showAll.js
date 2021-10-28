function drawTable(data, i) {
    return `<tr>
                                <td >${data.content[i].producer}</td>
                                <td >${data.content[i].model}</td>
                                <td >${data.content[i].price}</td>
                                <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="deleteSmartphone(${data.content[i].id})">Delete</button></td>
                                <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="editSmartphone(${data.content[i].id})">Edit</button></td>
                            </tr>`;
}

function draw(page) {
    return function (data) {
        let inner = "<table><tr><td>Producer</td><td>Model</td><td>Price</td><td>Delete</td><td>Edit</td></tr>";
        for (let i = 0; i < data.content.length; i++) {
            inner += drawTable(data, i);
        }
        inner += `</table> <br>`;
        let pageSize = data.totalPages;
        let disabledPre;
        if (page == 0) {
            disabledPre = "disabled";
        } else {
            disabledPre = "";
        }
        let disabledNext;
        if (page == pageSize - 1) {
            disabledNext = "disabled";
        } else {
            disabledNext = "";
        }
        inner += `<nav aria-label="...">
                          <ul class="pagination">
                            <li class="page-item ${disabledPre}">
                              <span class="page-link" onclick="showAll(${page - 1})">Previous</span>
                            </li>`

        for (let i = 0; i < pageSize; i++) {
            if (i == page) {
                inner += `<li class="page-item active"><button class="page-link" onclick="showAll(${i})">${i + 1}</button></li>`
            } else {
                inner += `<li class="page-item"><button class="page-link" onclick="showAll(${i})">${i + 1}</button></li>`
            }
        }
        inner += `<li class="page-item ${disabledNext}">
                          <button class="page-link" onclick="showAll(${page + 1})">Next</button>
                        </li>
                      </ul>
                    </nav>`
        document.getElementById('content').innerHTML = inner;
    };
}

function showAll(page) {
    let search = $('#search-smartphone').val();
    let url;

    $.ajax({
        type: "GET",
        url: `${path}?q=${search}&page=${page}`,
        success: draw(page)
    })
    event.preventDefault();
}