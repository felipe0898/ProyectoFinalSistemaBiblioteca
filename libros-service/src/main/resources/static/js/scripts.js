document.addEventListener("DOMContentLoaded", function () {
  // Obtener todos los libros al cargar la página
  fetchBooks();

  // Manejar el envío del formulario para agregar un libro
  document
    .getElementById("addBookForm")
    .addEventListener("submit", function (e) {
      e.preventDefault();

      const libro = {
        titulo: document.getElementById("titulo").value,
        autor: document.getElementById("autor").value,
        isbn: document.getElementById("isbn").value,
        categoria: document.getElementById("categoria").value,
        fechaPublicacion: document.getElementById("fechaPublicacion").value,
      };

      fetch("/libros", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(libro),
      })
        .then((response) => response.json())
        .then(() => {
          fetchBooks();
          document.getElementById("addBookForm").reset();
        });
    });

  // Manejar el envío del formulario para editar un libro
  document
    .getElementById("editBookForm")
    .addEventListener("submit", function (e) {
      e.preventDefault();

      const libro = {
        titulo: document.getElementById("editTitulo").value,
        autor: document.getElementById("editAutor").value,
        isbn: document.getElementById("editIsbn").value,
        categoria: document.getElementById("editCategoria").value,
        fechaPublicacion: document.getElementById("editFechaPublicacion").value,
      };

      const id = document.getElementById("editBookId").value;

      fetch(`/libros/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(libro),
      })
        .then((response) => response.json())
        .then(() => {
          fetchBooks();
          document.getElementById("editBookModal").modal("hide");
        });
    });
});

// Función para obtener todos los libros
function fetchBooks() {
  fetch("/libros")
    .then((response) => response.json())
    .then((data) => {
      const bookList = document.getElementById("bookList");
      bookList.innerHTML = "";

      data.forEach((libro) => {
        const row = document.createElement("tr");
        row.innerHTML = `
                  <td>${libro.id}</td>
                  <td>${libro.titulo}</td>
                  <td>${libro.autor}</td>
                  <td>${libro.isbn}</td>
                  <td>${libro.categoria}</td>
                  <td>${new Date(
                    libro.fechaPublicacion
                  ).toLocaleDateString()}</td>
                  <td>
                      <button class="btn btn-warning btn-sm" onclick="editBook('${
                        libro.id
                      }')">Editar</button>
                      <button class="btn btn-danger btn-sm" onclick="deleteBook('${
                        libro.id
                      }')">Eliminar</button>
                  </td>
              `;
        bookList.appendChild(row);
      });
    });
}

// Función para editar un libro
function editBook(id) {
  fetch(`/libros/${id}`)
    .then((response) => response.json())
    .then((libro) => {
      document.getElementById("editBookId").value = libro.id;
      document.getElementById("editTitulo").value = libro.titulo;
      document.getElementById("editAutor").value = libro.autor;
      document.getElementById("editIsbn").value = libro.isbn;
      document.getElementById("editCategoria").value = libro.categoria;
      document.getElementById("editFechaPublicacion").value =
        libro.fechaPublicacion;

      const editBookModal = new bootstrap.Modal(
        document.getElementById("editBookModal")
      );
      editBookModal.show();
    });
}

// Función para eliminar un libro
function deleteBook(id) {
  fetch(`/libros/${id}`, {
    method: "DELETE",
  }).then(() => fetchBooks());
}
