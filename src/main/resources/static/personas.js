function deletePersona(cedula) {
    if (confirm('¿Estás seguro de que deseas eliminar esta persona?')) {
        $.ajax({
            url: '/personas/delete/' + cedula,
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