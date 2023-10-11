// Función para eliminar un médico
function deleteMedico(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este médico?')) {
        $.ajax({
            url: '/medicos/delete/' + id,
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