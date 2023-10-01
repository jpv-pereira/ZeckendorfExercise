def getFibonacci(fibonacciList):
    fibonacciList.append(fibonacciList[len(fibonacciList) - 1] + fibonacciList[len(fibonacciList) - 2])
    return fibonacciList


def convertToZeckendorf(convertAmount):
    fibonacciList = [1, 2]
    zeckendorfList = ["0: 0"]


    for i in range(1, convertAmount + 1):
      if max(fibonacciList) < i:
          fibonacciList = (getFibonacci(fibonacciList))
      addition = 0
      converted = str(i) + ": "

      for fibonacciNumber in reversed(fibonacciList):
          if fibonacciNumber > i:
              continue
          if (addition + fibonacciNumber) <= i:
              addition += fibonacciNumber
              converted += "1"
              continue
          converted += "0"
      
      zeckendorfList.append(converted)
    return zeckendorfList
    
inputAmount = input()
convertAmount = 0

try:
    convertAmount = int(inputAmount)
except ValueError:
    print("Only numbers are accepted")
    exit(1)

if(convertAmount < 0):
    print("Only positive numbers or 0 are allowed")
    exit(1)

convertedList = convertToZeckendorf(convertAmount)
for convertedZeckendorf in convertedList:
    print(convertedZeckendorf)

