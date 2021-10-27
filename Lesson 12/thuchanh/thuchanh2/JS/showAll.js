function showAll(page) {
    let search = $('#search-smartphone').val();
    let url;

    $.ajax({
        type: "GET",
        url: `${path}?q=${search}&page=${page}`,
        success: function (data) {
            let inner = "<table><tr><td>Producer</td><td>Model</td><td>Price</td><td>Delete</td><td>Edit</td></tr>";
            for(let i=0; i<data.content.length;i++) {
                inner += `<tr>
                                <td >${data.content[i].producer}</td>
                                <td >${data.content[i].model}</td>
                                <td >${data.content[i].price}</td>
                                <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="deleteSmartphone(${data.content[i].id})">Delete</button></td>
                                <td><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="editSmartphone(${data.content[i].id})">Edit</button></td>
                            </tr>`;
            }
            inner += `</table> <br>`;
            inner += `<nav aria-label="Page navigation example">
                              <ul class="pagination">`
            let pageSize = data.totalPages;
            for(let i=0;i<pageSize;i++) {
                inner += `<li class="page-item"><button class="page-link" onclick="showAll(${i})">${i}</button></li>`
            }
            inner += `</ul></nav>`

            document.getElementById('content').innerHTML = inner;
        }
    })
    event.preventDefault();
}