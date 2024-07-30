$(document).ready(function() {
    // Функция для форматирования номера телефона
    function formatPhoneNumber(input) {
        let value = input.val();

        // Удаление всех символов, кроме цифр
        let cleanValue = value.replace(/\D/g, '');

        // Добавление фиксированного префикса "+7" перед остальным номером
        let formattedValue = cleanValue.replace(/(\d{1})?(\d{3})?(\d{3})?(\d{2})?(\d{2})?/, function(match, p1, p2, p3, p4, p5) {
            return '+7 ' + (p2 ? '(' + p2 + ')' : '') + (p3 ? ' ' + p3 : '') + (p4 ? '-' + p4 : '') + (p5 ? '-' + p5 : '');
        });

        // Установка отформатированного значения обратно в поле ввода
        input.val(formattedValue);
    }

    // Обработчик события для форматирования при вводе и выборе ячейки
    $('.phone-input').on('input', function() {
        formatPhoneNumber($(this));
    });

    $('.phone-input').on('focus', function() {
        formatPhoneNumber($(this));
    });
});
