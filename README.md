# Calc

Это мой учебный проект, который я делаю на 100% самостоятельно, не повторяя чей либо код.


Пока калькулятор ещё не работает полноценно и дизайн оставляет желать лучшего. Но постепенно всё заработает.

14.08.2021 - работает "+", "-", "=", ":", "х"
но пока всё идёт целыми числами через Long

15.08.2021 - теперь корректно считает и числа с точкой (используется BigDecimal), встроена защита от деления на 0

16.08.2021 - изменение цвета кнопки в момент нажатия (пока работает криво и кроме C и кнопки удаления, думаю нужно полностью переписать OnClick на OnTouch)

18.08.2021 - изменение цвета кнопки в момент нажатия (пофиксено, реализовано через XMl), фича не работает только в кнопке "удалить", потому что это ImageButton

19.08.2021 - чёт продуктивно:

- реализовано копирование текста
- пофиксил баг с расчётами, теперь считает корректно
- дочь нарисовала иконку приложения, добавил


![logo_calc_mini](https://user-images.githubusercontent.com/59067552/130119382-410a5f55-c647-4c78-91c3-6078a2d32c65.png)
- добавил другой цвет кнопки "удалить" при нажатии
- реализовал полное удаление по долгому нажатию кнопки "удалить"

21.08.2021 - реализован расчёт с кнопкой "%"




Известные баги:
- вылетает после того как нажимаешь назад (текстовое поле полностью очищается) и после вызываешь какую либо функцию

TODO:
- автопрокрутка в ScrollView


![scr](https://user-images.githubusercontent.com/59067552/129471271-75975962-3654-4d4e-b837-e24797fa8a09.png)

