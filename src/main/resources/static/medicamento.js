// Función para eliminar un medicamento
function deleteMedicamento(nombre) {
    if (confirm('¿Estás seguro de que deseas eliminar este medicamento?')) {
        $.ajax({
            url: '/medicamentos/delete/' + nombre,
            type: 'DELETE',
            success: function(response) {
                // Actualizar la vista o realizar otras acciones necesarias
                location.reload(); // Recargar la página
            },
            error: function(error) {
                // Manejar errores
            }
        });
    }
}