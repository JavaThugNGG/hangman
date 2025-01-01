# Hangman Game 

"Hangman Game" — это консольная реализация классической игры "Виселица". Цель игры — угадать слово, вводя буквы по одной. 

## Правила игры

1. Игроку предлагается загадать слово, которое скрыто звездочками.
2. Игрок должен поочередно вводить буквы. Если буква присутствует в слове, она будет открыта.
3. Если буквы нет в слове, количество ошибок увеличивается.
4. Если количество ошибок достигает 6, игрок проигрывает. Если все буквы открыты до этого, игрок выигрывает.


## Уровни сложности

- **Легкий**: Загадка слова с подсказкой (описанием слова) и открытыми двумя буквами.
- **Средний**: Загадка слова с подсказкой, но без открытых букв.
- **Сложный**: Без подсказок и открытых букв.

## Структура игры

- Игра предлагает слово из словаря, состоящего из слов и их определений, сохранённых в файле `words.txt`.
- Слово отображается в виде маски, где все буквы скрыты звездочками.
- Игрок может вводить только одну букву за раз.
- В случае выигрыша или проигрыша выводится разгаданное слово и его описание.



Каждое слово в словаре будет использоваться для случайной генерации загадки.

## Как играть

1. Запустите программу.
2. Выберите уровень сложности.
3. Начинайте угадывать буквы.
4. Если хотите сыграть снова, выберите "Y" (да) после окончания игры.

