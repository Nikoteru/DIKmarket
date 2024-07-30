
// Объявляем глобальные переменные
let globalWidth = 0;
let globalLength = 0;
let globalStageKEF = 1; // Начальное значение 1, чтобы не было умножения на null
let globalBasementKEF = 1;
let globalOverlayKEF = 1;
let globalRoofKEF = 1;
let globalMaterialKEF = 1;
let defaultCost = 50000; // Пример значения defaultCost
let mCost = 0;
let totalCost = 0;
let totalArea = 0;

function calculateMCost() {
    mCost = (defaultCost * globalBasementKEF * globalOverlayKEF * globalRoofKEF * globalMaterialKEF).toFixed(2);
    console.log('Стоимость (mCost): ' + mCost);

    const mCostInput = document.getElementById('mCost');
    if (mCostInput) {
        mCostInput.value = mCost;
    } else {
        console.error('Element with ID "mCost" not found');
    }
}

function calculateTotalArea() {
    totalArea = (globalStageKEF * globalWidth * globalLength).toFixed(2);
    console.log('Площадь (totalArea): ' + totalArea);

    const totalAreaInput = document.getElementById('totalArea');
    if (totalAreaInput) {
        totalAreaInput.value = totalArea;
    } else {
        console.error('Element with ID "mCost" not found');
    }
}


function calculateTotalCost() {
    totalCost = (mCost*totalArea).toFixed(2);
    console.log('Стоимость (totalCost): ' + totalCost);

    const totalCostInput = document.getElementById('totalCost');
    if (totalCostInput) {
        totalCostInput.value = totalCost;
    } else {
        console.error('Element with ID "mCost" not found');
    }
}


document.addEventListener("DOMContentLoaded", function() {
    // Получаем элементы input по ID
    const projectWidthInput = document.getElementById('projectWidth');
    const projectLengthInput = document.getElementById('projectLength');

    // Получаем элементы select по ID
    const stageSelect = document.getElementById('stage.id');
    const basementSelect = document.getElementById('basement.id');
    const overlaySelect = document.getElementById('overlay.id');
    const roofSelect = document.getElementById('roof.id');
    const materialSelect = document.getElementById('material.id');

    // Проверка, существуют ли элементы и добавление обработчиков событий для input
    if (projectWidthInput) {
        projectWidthInput.addEventListener('input', function() {
            globalWidth = projectWidthInput.value;
            console.log('Ширина: ' + globalWidth);
            calculateMCost();
            calculateTotalArea();
            calculateTotalCost();
        });
    } else {
        console.error('Element with ID "projectWidth" not found');
    }

    if (projectLengthInput) {
        projectLengthInput.addEventListener('input', function() {
            globalLength = projectLengthInput.value;
            console.log('Длина: ' + globalLength);
            calculateMCost();
            calculateTotalArea();
            calculateTotalCost();
        });
    } else {
        console.error('Element with ID "projectLength" not found');
    }

    // Проверка, существуют ли элементы и добавление обработчиков событий для select
    if (stageSelect) {
        stageSelect.addEventListener('change', function() {
            globalStageKEF = stageSelect.options[stageSelect.selectedIndex].getAttribute('data-kef') || 1;
            console.log('Количество этажей (KEF): ' + globalStageKEF);
            calculateMCost();
            calculateTotalArea();
            calculateTotalCost();
        });
    } else {
        console.error('Element with ID "stage.id" not found');
    }

    if (basementSelect) {
        basementSelect.addEventListener('change', function() {
            globalBasementKEF = basementSelect.options[basementSelect.selectedIndex].getAttribute('data-kef') || 1;
            console.log('Тип фундамента (KEF): ' + globalBasementKEF);
            calculateMCost();
            calculateTotalArea();
            calculateTotalCost();
        });
    } else {
        console.error('Element with ID "basement.id" not found');
    }

    if (overlaySelect) {
        overlaySelect.addEventListener('change', function() {
            globalOverlayKEF = overlaySelect.options[overlaySelect.selectedIndex].getAttribute('data-kef') || 1;
            console.log('Тип перекрытий (KEF): ' + globalOverlayKEF);
            calculateMCost();
            calculateTotalArea();
            calculateTotalCost();
        });
    } else {
        console.error('Element with ID "overlay.id" not found');
    }

    if (roofSelect) {
        roofSelect.addEventListener('change', function() {
            globalRoofKEF = roofSelect.options[roofSelect.selectedIndex].getAttribute('data-kef') || 1;
            console.log('Тип крыши (KEF): ' + globalRoofKEF);
            calculateMCost();
            calculateTotalArea();
            calculateTotalCost();
        });
    } else {
        console.error('Element with ID "roof.id" not found');
    }

    if (materialSelect) {
        materialSelect.addEventListener('change', function() {
            globalMaterialKEF = materialSelect.options[materialSelect.selectedIndex].getAttribute('data-kef') || 1;
            console.log('Материал короба (KEF): ' + globalMaterialKEF);
            calculateMCost();
            calculateTotalArea();
            calculateTotalCost();
        });
    } else {
        console.error('Element with ID "material.id" not found');
    }
});