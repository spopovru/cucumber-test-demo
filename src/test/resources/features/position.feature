# language: ru
@arena @robot @position
Функционал: Проверка возможности добавления робота в произвольную позицию

  Структура сценария: Добавление робота в произвольную позицию (<Позиция X>; <Позиция Y>)
    * создана арена шириной 4 и высотой 4
    * добавлен робот "<Имя робота>" в позицию (<Позиция X>; <Позиция Y>)
    * количество роботов на арене равно 1
    * робот "<Имя робота>" находится в позиции (<Позиция X>; <Позиция Y>)

    Примеры:
      | Имя робота | Позиция X | Позиция Y |
      | Вася       | 0         | 0         |
      | Коля       | 1         | 1         |
      | Женя       | 2         | 2         |
      | Альберт    | 3         | 3         |
      | Курт       | 0         | 3         |
      | Борис      | 2         | 0         |
      | Георгий    | 1         | 3         |
      | Альфонс    | 3         | 1         |
      | Иван       | 1         | 0         |