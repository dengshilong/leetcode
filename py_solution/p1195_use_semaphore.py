import threading


class FizzBuzz(object):
    def __init__(self, n):
        self.n = n
        self.sn = threading.Semaphore(0)
        self.sf = threading.Semaphore(0)
        self.sb = threading.Semaphore(0)
        self.sfb = threading.Semaphore(0)

    # printFizz() outputs "fizz"
    def fizz(self, printFizz):
        """
        :type printFizz: method
        :rtype: void
        """
        for i in range(3, self.n + 1, 3):
            if i % 5 != 0:
                self.sf.acquire()
                printFizz()
                self.sn.release()

    # printBuzz() outputs "buzz"
    def buzz(self, printBuzz):
        """
        :type printBuzz: method
        :rtype: void
        """
        for i in range(5, self.n + 1, 5):
            if i % 3 != 0:
                self.sb.acquire()
                printBuzz()
                self.sn.release()

    # printFizzBuzz() outputs "fizzbuzz"
    def fizzbuzz(self, printFizzBuzz):
        """
        :type printFizzBuzz: method
        :rtype: void
        """
        for i in range(15, self.n + 1, 15):
            self.sfb.acquire()
            printFizzBuzz()
            self.sn.release()

    # printNumber(x) outputs "x", where x is an integer.
    def number(self, printNumber):
        """
        :type printNumber: method
        :rtype: void
        """
        for i in range(1, self.n + 1):
            if i % 15 == 0:
                self.sfb.release()
                self.sn.acquire()
            elif i % 3 == 0:
                self.sf.release()
                self.sn.acquire()
            elif i % 5 == 0:
                self.sb.release()
                self.sn.acquire()
            else:
                printNumber(i)


def printNumber(x):
    print(str(x))