## Домашние работы к курсу «Введение в программирование»

[Условия домашних заданий](https://web.archive.org/web/20220705034247/http://www.kgeorgiy.info/courses/prog-intro/homeworks.html)

[Домашнее задание 13. Обработка ошибок]
----
1. Добавьте в программу вычисляющую выражения обработку ошибок, в том числе:
- ошибки разбора выражений;
- ошибки вычисления выражений.
2. При выполнении задания следует обратить внимание на дизайн и обработку исключений.
3. Человеко-читаемые сообщения об ошибках должны выводится на консоль.
4. Программа не должна «вылетать» с исключениями (как стандартными, так и добавленными).
#### Модификации



[Домашнее задание 12. Разбор выражений]
----
1. Доработайте предыдущее домашнее задание, так что бы выражение строилось по записи вида
``` x * (x - 2)* x + 1 ```

2. В записи выражения могут встречаться: умножение *, деление /, сложение +, вычитание -, унарный минус -, целочисленные константы (в десятичной системе счисления, которые помещаются в 32-битный знаковый целочисленный тип), круглые скобки, переменные (x) и произвольное число пробельных символов в любом месте (но не внутри констант).

3. Приоритет операторов, начиная с наивысшего:
- унарный минус;
- умножение и деление;
- сложение и вычитание.

Разбор выражений рекомендуется производить методом рекурсивного спуска. Алгоритм должен работать за линейное время.

#### Модификации
 * *Shifts* (38, 39)
    * Дополнительно реализуйте бинарные операции с минимальным приоритетом:
        * `<<` – сдвиг влево (`1 << 5 + 3` равно `1 << (5 + 3)` равно 256);
        * `>>` – сдвиг вправо (`1024 >> 5 + 3` равно `1024 >> (5 + 3)` равно 4);
        * `>>>` – арифметический сдвиг вправо (`-1024 >>> 5 + 3` равно `1024 >>> (5 + 3)` равно -4);
 * *MinMax* (34-37)
    * Дополнительно реализуйте бинарные операции (минимальный приоритет):
        * `min` – минимум, `2 min 3` равно 2;
        * `max` – максимум, `2 max 3` равно 3.
 * *Zeroes* (31-33, 36-39)
    * Дополнительно реализуйте унарные операции
      * `l0` – число старших нулевых бит, `l0 123456` равно 15;
      * `t0` – число младших нулевых бит, `t0 123456` равно 6.


[Домашнее задание 11. Выражения]
----
1. Разработайте классы Const, Variable, Add, Subtract, Multiply, Divide для вычисления выражений с одной переменной.

2. Классы должны позволять составлять выражения вида
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).evaluate(5)
```

3. Метод toString должен выдавать запись выражения в полноскобочной форме. Например
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toString()
```
должен выдавать ```((2 * x) - 3)```.

4. Метод toMiniString должен выдавать выражение с минимальным числом скобок. Например
```
new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
).toMiniString()
```
должен выдавать ```2 * x - 3```.

5. Реализуйте метод equals, проверяющий, что два выражения совпадают.

6. При выполнение задания следует обратить внимание на:

- Выделение общего интерфейса создаваемых классов.

- Выделение абстрактного базового класса для бинарных операций.

#### Модификации
 * *Triple* (31-39)
    * Дополнительно реализуйте поддержку выражений с тремя переменными: `x`, `y` и `z`.
 * *BigInteger* (36-37)
    * Дополнительно реализуйте вычисления в типе `BigInteger`.
 * *BigDecimal* (38-39)
    * Дополнительно реализуйте вычисления в типе `BigDecimal` .

[Домашнее задание 10. Игра n,m,k]
----
1. Реализуйте игру m,n,k.

2. Добавьте обработку ошибок ввода пользователя.

3. Проверку выигрыша нужно производить за O(k).

4. Предотвратите жульничество: у игрока не должно быть возможности достать Board из Position. (hard mode)

#### Модификации
 * *Переговоры* (38-39)
    * У игрока должна быть возможность сдаться, если он не хочет продолжать игру.
    * Игрок может вместо своего хода предложить ничью.
      Если второй игрок принимает предложение, то игра заканчивается.
      В противном случае, игра продолжается и игрок делает ход.
      Повторное предложение ничьей на том же ходу считается ошибкой.
 * *Турнир* (36-37)
    * Добавьте поддержку кругового турнира для нескольких участников.
    * В рамках кругового турнира каждый с каждым должен сыграть две партии,
      по одной каждым цветом.
    * Выведите таблицу очков по схеме:
        * 3 очка за победу;
        * 1 очко за ничью;
        * 0 очков за поражение.
 * *Гекс* (36-39)
    * Добавьте поддержку ромбической доски для
      [игры Гекс](https://ru.wikipedia.org/wiki/Гекс)
      (с тремя направлениями линий).
    * В качестве примера, сделайте доску размером <em>11×11</em>.
 * *Multiplayer* (34-35)
    * Добавьте поддержку значков `-` и `|`;
    * Добавьте возможность игры для 3 и 4 игроков.
 * *Матчи* (31-33)
    * Добавьте поддержку матчей: последовательность игр до указанного числа побед.
    * Стороны в матче должны меняться каждую игру.

[Домашнее задание 9. Markdown to HTML]
----
1. Разработайте конвертер из Markdown-разметки в HTML.

2. Конвертер должен называться Md2Html и принимать два аргумента: название входного файла с Markdown-разметкой и название выходного файла c HTML-разметкой.

#### Модификации
  * *InsDel* (38, 39)
    * Добавьте поддержку
        `<<вставок>>`: `<ins>вставок</ins>` и
        `}}удалений{{`: `<del>удалений</del>`
 * *Pre* (36, 37)
    * Добавьте поддержку
      \`\`\``кода __без__ форматирования`\`\`\`:
      `<pre>кода __без__ форматирования</pre>`
 * *Quote* (34, 35)
    * Добавьте поддержку `''цитат''`: `<q>цитат</q>`
 * *Var* (31-33)
    * Добавьте поддержку `%переменных%`: `<var>переменных</var>`


[Домашнее задание 7. Разметка]
----
1. Разработайте набор классов для текстовой разметки.

2. Класс Paragraph может содержать произвольное число других элементов разметки и текстовых элементов.

3. Класс Text – текстовый элемент.

4. Классы разметки Emphasis, Strong, Strikeout – выделение, сильное выделение и зачеркивание. Элементы разметки могут содержать произвольное число других элементов разметки и текстовых элементов.

5. Все классы должны реализовывать метод toMarkdown(StringBuilder), которой должен генерировать Markdown-разметку по следующим правилам.
        текстовые элементы выводятся как есть;
        выделенный текст окружается символами '*';
        сильно выделенный текст окружается символами '__';
        зачеркнутый текст окружается символами '~'.

6. Следующий код должен успешно компилироваться:

    Paragraph paragraph = new Paragraph(List.of(
        new Strong(List.of(
            new Text("1"),
            new Strikeout(List.of(
                new Text("2"),
                new Emphasis(List.of(
                    new Text("3"),
                    new Text("4")
                )),
                new Text("5")
            )),
            new Text("6")
        ))
    ));

7. Вызов paragraph.toMarkdown(new StringBuilder()) должен заполнять переданный StringBuilder следующим содержимым:
    __1~2*34*5~6__
8. Разработанные классы должны находиться в пакете markup

#### Модификации
 * *Html* (34, 35)
    * Дополнительно реализуйте метод `toHtml`, генерирующий HTML-разметку:
      * выделеный текст окружается тегом `em`;
      * сильно выделеный текст окружается тегом `strong`;
      * зачеркнутый текст окружается тегом `s`.
 * *HtmlList* (38, 39)
    * Сделайте модификацию *Html*
    * Добавьте поддержку:
      * Нумерованных списков (класс `OrderedList`, тег `ol`): последовательность элементов
      * Ненумерованных списков (класс `UnorderedList`, тег `ul`): последовательность элементов
      * Элементов списка (класс `ListItem`, тег `li`): последовательность абзацев и списков
    * Для новых классов поддержка Markdown не требуется
 * *BBCode* (31-33)
    * Дополнительно реализуйте метод `toBBCode`, генерирующий [BBCode](https://en.wikipedia.org/wiki/BBCode)-разметку:
      * выделеный текст окружается тегом `i`;
      * сильно выделеный текст окружается тегом `b`;
      * зачеркнутый текст окружается тегом `s`.
 * *BBCodeList* (36, 37)
    * Сделайте модификацию *BBCode*
    * Добавьте поддержку:
      * Нумерованных списков (класс `OrderedList`, тег `list=1`): последовательность элементов
      * Ненумерованных списков (класс `UnorderedList`, тег `list`): последовательность элементов
      * Элементов списка (класс `ListItem`, открывающий тег `*`): последовательность абзацев и списков
    * Для новых классов поддержка Markdown не требуется


[Домашнее задание 6. Подсчет слов++]
----
1. Разработайте класс WordStatIndex, который будет подсчитывать статистику встречаемости слов во входном файле.

2. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появления. Для каждого слова должна быть выведена одна строка, содержащая слово, число его вхождений во входной файл и номера вхождений этого слова среди всех слов во входном файле.

3. Программа должна работать за линейное от размера входного файла время.

4. Для реализации программы используйте Collections Framework.

5. Реализуйте и примените класс IntList, компактно хранящий список целых чисел. *(hard mode)*

#### Модификации
 * *SortedSecondG* (38-39)
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Вместо номеров вхождений во всем файле надо указывать
      только четныe вхождения в каждой строке.
    * Класс должен иметь имя `WsppSortedSecondG`
 * *SecondG* (36-37)
    * Вместо номеров вхождений во всем файле надо указывать
      только четныe вхождения в каждой строке.
    * Класс должен иметь имя `WsppSecondG`
 * *SortedPosition* (34-35)
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Вместо номеров вхождений во всем файле надо указывать
      `<номер строки>:<номер в строке>`
    * Класс должен иметь имя `WsppSortedPosition`
 * *Position* (31-33)
    * Вместо номеров вхождений во всем файле надо указывать
      `<номер строки>:<номер в строке>`
    * Класс должен иметь имя `WsppPosition`


[Домашнее задание 5. Свой сканнер]
----
1. Реализуйте свой аналог класса Scanner на основе Reader.

2. Примените разработанный Scanner для решения заданий «Реверс» и «Статистика слов».

3. Код, управляющий чтением должен быть общим.

4. Код, выделяющий числа и слова должен быть общим.

#### Модификации
 * *HexAbc2* (38-39)
    * На вход подаются десятичные и шестнадцатеричные числа
    * Шестнадцатеричные числа имеют префикс `0x`
    * Десятеричные числа могут быть записаны буквами
      нулю соответствует буква `a`, единице – `b` и так далее
    * Выведите все числа, используя буквенный формат
    * Класс должен иметь имя `ReverseHexAbc2`
 * *Linear* (38-39)
    * Пусть _n_ – сумма числа чисел и строк во входе,
      тогда программе разрешается потратить не более 5 _n_ +O(1) памяти
 * *HexDec2* (36-37)
    * На вход подаются десятичные и шестнадцатеричные числа
    * Шестнадцатеричные числа имеют префикс `0x`
    * Выведите все числа, используя формат шестнадцатеричных чисел
    * Класс должен иметь имя `ReverseHexDec2`
 * *Hex2* (34-35)
    * Во вводе используются числа в шестнадцатеричной системе счисления
    * Класс должен иметь имя `ReverseHex2`
 * *Abc2* (31-33)
    * Во вводе и выводе используются числа, записаные буквами:
      нулю соответствует буква `a`, единице – `b` и так далее
    * Класс должен иметь имя `ReverseAbc2`


[Домашнее задание 4. Подсчет слов]
----
Разработайте класс WordStat, который будет подсчитывать статистику встречаемости слов во входном файле.

Словом называется непрерывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash).
Для подсчета статистики, слова приводятся к нижнему регистру.

#### Модификации
 * *Count* (34, 35, 38, 39)
    * В выходном файле слова должны быть упорядочены по возрастанию числа
      вхождений, а при равном числе вхождений – по порядку первого вхождения
      во входном файле.
    * Класс должен иметь имя `WordStatCount`
 * *Words* (31, 32, 33, 36, 37)
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Класс должен иметь имя `WordStatWords`
 * *Sort* (36-39)
    * Пусть _n_ – число слов во входном файле,
      тогда программа должна работать за O(_n_ log _n_).


[Домашнее задание 3. Реверс]
----
Разработайте класс Reverse, читающий числа из стандартного входа, и выводящий их на стандартный вывод в обратном порядке.

#### Модификации:
 * *Sum2* (38, 39)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите сумму чисел
      в прямоугольнике верхний левый угол матрицы — текущее число
    * Класс должен иметь имя `ReverseSum2`
 * *Min2* (36, 37)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите минимум из чисел
      верхний левый угол матрицы — текущее число
    * Класс должен иметь имя `ReverseMin2`
 * *Linear* (36-39)
    * Пусть _n_ – сумма числа чисел и строк во входе,
      тогда программе разрешается потратить не более 6_n_+O(1) памяти
 * *Transpose* (34-35)
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      выведите ее в транспонированном виде
    * Класс должен иметь имя `ReverseTranspose`
 * *Odd2* (31-33)
    * Выведите (в реверсивном порядке) только числа,
      у которых сумма номеров строки и столбца нечетная
    * Класс должен иметь имя `ReverseOdd2`



[Домашнее задание 2. Сумма чисел]
----
Разработайте класс Sum, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.

Модификации
 * *BigIntegerHex* (38-39)
    * Входные данные помещаются в тип [BigInteger](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigInteger.html)
    * Шестнадцатеричные числа имеют префикс `0x`
    * Класс должен иметь имя `SumBigIntegerHex`
 * *LongHex* (36-37)
    * Входные данные являются 64-битными целыми числами
    * Шестнадцатеричные числа имеют префикс `0x`
    * Класс должен иметь имя `SumLongHex`
 * *Float* (34-35)
    * Входные данные являются 32-битными числами с формате с плавающей точкой
    * Класс должен иметь имя `SumFloat`
    * Числа разделяются [пробелами-разделителями](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html#SPACE_SEPARATOR)
 * *Long* (31-33)
    * Входные данные являются 64-битными целыми числами
    * Класс должен иметь имя `SumLong`
