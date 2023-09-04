// ----------------------------------Задание №0----------------------------------
// Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
// Если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки, иначе - длину массива.

const numbers = {
    array__length: function(array) {
        const userInput = parseInt(prompt("Введите число: "));
        if (userInput > array.length){
            return -1;
        } else {
            return array.length;
        } 
    }
};


const integerArray = [1, 2, 3, 4, 5];
const result = numbers.array__length(integerArray);
console.log(result);


// ----------------------------------Задание №1----------------------------------
// Реализуйте метод, принимающий в качестве аргумента 
// целочисленный массив и некоторое значение. 
// Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
// если длина массива меньше некоторого заданного минимума, 
// метод возвращает -1, в качестве кода ошибки.
// если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
// если вместо массива пришел null, метод вернет -3
// придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
// Напишите метод, в котором реализуйте взаимодействие с пользователем. 
// То есть, этот метод запросит искомое число у пользователя, вызовет первый, 
// обработает возвращенное значение и покажет читаемый результат пользователю. 
// Например, если вернулся -2, пользователю выведется сообщение: 
// “Искомый элемент не найден”.


const numbers = {
    array__length: function(array) {
        if (array === null) {
            return -3;
        }
    
        const userInput = parseInt(prompt("Введите число: "));
        if (isNaN(userInput)) {
            return -4;
        }
    
        if (userInput >= array.length) {
            return -1;
        }
    
        for (let index = 0; index < array.length; index++) {
            if (array[index] == userInput) {
                return index;
            }
        }
        return -2;
    },
    interactive: function() {
        const errorOrIndex = this.array__length([1, 2, 3, 4, 5]); 
        switch (errorOrIndex) {
            case -1:
                return "длина массива меньше заданного минимума";
            case -2:
                return "искомый элемент не найден";
            case -3:
                return "вместо массива пришел null";
            case -4:
                return "Вы ввели не число";
            default:
                return `Найден индекс: ${errorOrIndex}`;
        }
    }
};

const result = numbers.interactive();
console.log(result);

// ----------------------------------Задание №2----------------------------------

// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив. 
// Необходимо посчитать и вернуть сумму элементов этого массива. 
// При этом накладываем на метод 2 ограничения: 
// метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов), 
// и в каждой ячейке может лежать только значение 0 или 1. 
// Если нарушается одно из условий, 
// метод должен бросить RuntimeException с сообщением об ошибке.

const numbers = {
    array__length: function(array) {
        const rows = array.length;
        const cols = array[0].length;

        for (let i = 0; i < rows; i++) {
            if (array[i].length !== cols) {
                return 'RuntimeException: метод может работать только с квадратными массивами';
            }
            for (let j = 0; j < cols; j++) {
                if (array[i][j] !== 0 && array[i][j] !== 1) {
                    return 'RuntimeException: в каждой ячейке может лежать только значение 0 или 1';
                }
            }
        }

        let sumNumbers = 0;
        for (let i = 0; i < rows; i++) {
            for (let j = 0; j < cols; j++) {
                sumNumbers += array[i][j];
            }
        }
        return sumNumbers;
    }
};

const integerArray = [[1, 0, 1, 1, 1], [0, 1, 0, 1, 0]];
const result = numbers.array__length(integerArray);
console.log(result);

// ----------------------------------Задание №3----------------------------------

// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив. 
// Необходимо посчитать и вернуть сумму элементов этого массива. 
// При этом накладываем на метод 2 ограничения: 
// метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1. 
// Если нарушается одно из условий, метод должен вернуть код ошибки. 
// Программа должна корректно обработать код ошибки 
// и вывести соответствующее сообщение пользователю. 
// Сравнить такой вариант обработки исключений с предыдущим. 
// Какое преимущество у исключений перед кодами ошибок вы можете назвать в данном случае?


const integerArray = [[1, 0, 1, 1, 1], [0, 1, 0, 1, 0]];

const numbers = {
    array__length: function(array) {
        const rows = array.length;
        const cols = array[0].length;

        for (let i = 0; i < rows; i++) {
            if (array[i].length !== cols) {
                return -1;
            }
            for (let j = 0; j < cols; j++) {
                if (array[i][j] !== 0 && array[i][j] !== 1) {
                    return -2;
                }
            }
        }

        let sumNumbers = 0;
        for (let i = 0; i < rows; i++) {
            for (let j = 0; j < cols; j++) {
                sumNumbers += array[i][j];
            }
        }
        return sumNumbers;
    },


    interactive: function() {
        const sumNumbers = this.array__length(integerArray);
        switch (sumNumbers) {
            case -1:
                return "метод может работать только с квадратными массивами";
            case -2:
                return "в каждой ячейке может лежать только значение 0 или 1.";
            default:
                return sumNumbers;
        }
    }
};


const result = numbers.interactive();
console.log(result);


// ----------------------------------Задание №4----------------------------------


// Реализуйте метод checkArray(Integer[] arr), принимающий 
// в качестве аргумента целочисленный одномерный массив. 
// Метод должен пройтись по каждому элементу и проверить что он не равен null. 
// А теперь реализуйте следующую логику:
// Если в какой-то ячейке встретился null, то необходимо “оповестить” 
// об этом пользователя
// Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”


const numbers = {
    checkArray: function(array) {
        for (let index = 0; index < array.length; index++) {
            if( array[index] == null){
                array[index] = "---" + array[index] + "---";
            } 
        }
        return array;
    }
};


const integerArray = [1, null, 3, 4, 5];
const result = numbers.checkArray(integerArray);
console.log(result);


// ----------------------------------Задание №5----------------------------------

// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
// и возвращающий новый массив, каждый элемент которого равен сумме 
// элементов двух входящих массивов в той же ячейке.
// Если длины массивов не равны, необходимо как-то оповестить пользователя.

const numbers = {
    array__length: function(array1,array2) {

        if (array1.length !== array2.length){
            return "метод может работать только с равными массивами"
        }

        const newarray  = [array1.length];
        for (let index = 0; index < array1.length; index++) {
            newarray[index] = array1[index]+array2[index];
        }

        return newarray;
    }
};


const integerArray1 = [1, 2, 3, 4, 5];
const integerArray2 = [1, 2, 3, 4, 5];

const result = numbers.array__length(integerArray1,integerArray2);
console.log(result);


// ----------------------------------Задание №6----------------------------------

// Реализуйте метод, принимающий в качестве аргументов двумерный массив. 
// Метод должен проверить что длина строк и столбцов с одинаковым 
// индексом одинакова, детализировать какие строки со столбцами не требуется. 


const integerArray = [[1, 0, 1, 1, 1], [0, 1, 0, 1, 0]];

const numbers = {
    array__length: function(array) {
        const rows = array.length;
        const cols = array[0].length;

        const mismatchedIndexes = [];

        for (let i = 0; i < rows; i++) {
            for (let j = 0; j < cols; j++) {
                if (array[i].length !== cols) {
                    mismatchedIndexes.push({ row: i, col: j });
                }
            }
        }

        return mismatchedIndexes;
    },

    interactive: function() {
        const mismatchedPairs = this.array__length(integerArray);
        
        if (mismatchedPairs.length === 0) {
            return "Строки и столбцы имеют одинаковую длину.";
        } else {
            let message = "Не совпадают длины строк и столбцов для следующих пар: ";
            for (let i = 0; i < mismatchedPairs.length; i++) {
                const pair = mismatchedPairs[i];
                message += `{строка ${pair.row} и столбец ${pair.col}}, `;
            }
            return message;
        }
    }
};

const result = numbers.interactive();
console.log(result);


