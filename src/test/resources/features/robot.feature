#language: ru

@robot
Функционал: Перемещение роботов

  Предыстория:
    Пусть создана арена шириной 10 и высотой 10

  Сценарий: Перемещение робота
    Пусть добавлен робот "Вася" в позицию (0; 0)
    Когда робот "Вася" переместился вправо на 9 шагов
    И робот "Вася" переместился вниз на 9 шагов
    И робот "Вася" переместился влево на 9 шагов
    И робот "Вася" переместился вверх на 9 шагов
    Тогда робот "Вася" находится в позиции (0; 0)

  Сценарий: Невозможность перемещения робота за пределы арены
    Пусть добавлен робот "Вася" в позицию (0; 0)
    Когда робот "Вася" переместился вправо на 10 шагов происходит ошибка выхода за пределы арены
    Когда робот "Вася" переместился вниз на 10 шагов происходит ошибка выхода за пределы арены
    Когда робот "Вася" переместился влево на 1 шаг происходит ошибка выхода за пределы арены
    Когда робот "Вася" переместился вверх на 1 шаг происходит ошибка выхода за пределы арены

  Сценарий: Невозможность перемещения робота в занятую ячейку
    Пусть добавлен робот "Вася" в позицию (0; 0)
    И добавлен робот "Петя" в позицию (2; 2)
    Когда робот "Вася" переместился вправо на 2 шага
    Тогда робот "Вася" находится в позиции (2; 0)
    Когда робот "Вася" переместился вниз на 2 шага происходит ошибка столкновения с другим роботом
    Тогда робот "Вася" находится в позиции (2; 0)
    Когда робот "Петя" переместился вверх на 2 шага происходит ошибка столкновения с другим роботом
    Тогда робот "Петя" находится в позиции (2; 2)
    Когда робот "Петя" переместился вправо на 1 шаг
    И робот "Вася" переместился вниз на 2 шага
    Тогда робот "Вася" находится в позиции (2; 2)
    И робот "Петя" находится в позиции (3; 2)