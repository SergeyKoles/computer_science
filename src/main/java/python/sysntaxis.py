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


x = 2014 ** 14
print(x)
