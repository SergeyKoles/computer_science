# x = 239 // 23 - целочисленное деление
# x = 5 ** 3    - возведение в степень
# x = 5e - 1    - 0.5
# int(x)        - преобразование к целому числу
# float(x)      - преобразование к числу с плавуещей точкой
# type(x)       - узнать тип объекта

#  input()      - читает строку с клавиатуры
#  input('введите данные')      - выводит сообщение и потом читает строку с клавиатуры
#  s = input()
#  a = int(input())
# a, b = input().split()
# a, b = (int(i) for i in input().split())

# x or y, x and y, not x - логические операции с bool

# if a > b :
#     print(a)
# elif a < b :
#     print('b')
# else:
#     print(b)

# 'abc' + 'def'
# 'abcdef'
# 'abc' * 3
# 'abcabcabc'
# len('abc')
# 3

# 'abc' < 'ac' - true - сранение лексиграфически

# a = 5
# while a > 0:
#     print(a, end=' ') # end= - разделить пробелом
#     a -= 1

# for i in 2, 3, 4:
#     print(i)

# for i in range(10):
#     print(i)

# range(start=0, to, step=1)
# range(5)            - 0,1,2,3,4 шаг 1
# range(2, 5)         - 2,3,4 шаг 1
# range(2, 15, 4)     - 2,6,10,14 шаг 4

# genome = 'ATGG'
# genome[0] # A       genome[-1] # G
# genome[1] # T       genome[-2] # G
# genome[2] # G       genome[-3] # T
# genome[3] # G       genome[-4] # A

# for c in genome:
#     print(c)

# genome = input()
# print(genome.count('C'))        # считает количество вхождений символа в строку

##################### Методы строк
# s = 'aTGcc'
# p = 'cc'
# s.upper()
# s.lower()
# s.count(p)
# s.find(p)
# s.find('A')   == if 'TG' in s:
# s.replace('c', 'C')

#################### Slicing
# dna ='ATTCGGAGCT'
# dna[1]      # T
# dna[1:4]    # TTC
# dna[:4]     # ATTC
# dna[-4:]    # AGCT
# dna[1:-1]   # TTCGGAGC
# dna[1:-1:2] # TCGG
# dna[::-1]   # TCGAGGCTTTA - в обратном порядке

################### Списки
students = ['Ivan', 'Masha', 'Sasha']
for student in students:
    print(student)
len(students)
# Slicing доступен
teachers = ['Oleg', 'Alex']
students + teachers         #  - ['Ivan', 'Masha', 'Sasha', 'Oleg', 'Alex']

nums = [0, 1]
nums * 4                    # - [0, 1, 0, 1, 0, 1, 0, 1]
students.append('Olga')
students += ['Olga']
students += ['Boris', 'Sergey']
students.insert(1, 'Olga')
students.remove('Sasha')        # удаляет только первое значение, кидает ошибку, если элемента нет в списке
del students[0]

if 'Ivan' in students:
    print('true')
if 'Ann' not in students:
    print('True')
ind = students.index('Sasha')      # кидает исключение если нет элемента в списке

ordered_stud = sorted(students)     # сортирует не изменяя список
students.sort()                     # изменяет список
min(students)
max(students)
students.reverse()                  # не изменяя список = students[::-1]
reversed(students)                  # изменяет список
################### Генерация спсиска
a = [0] * 5                             # - [0, 0, 0, 0, 0]
a = [0 for i in range(5)]               # - [0, 0, 0, 0, 0]
a = [i * i for i in range(5)]           # - [0, 1, 4, 9, 16]
a = [int(i) for i in input().split()]

################## Двумерные списки
a = [[1, 2, 3], [4, 5, 6, ], [7, 8, 9]]
n = 3
a = [[0] * n] * 3                   # создает строчку из и элеменотов и КОПИРУЕТ ее т раз
a = [[0] * n for i in range(n)]
a = [[0 for j in range(n)] for i in range(n)]
