import threading


class ZeroEvenOdd(object):
    def __init__(self, n):
        self.n = n
        self.lz = threading.Lock()
        self.le = threading.Lock()
        self.lo = threading.Lock()
        self.cur = 1
        self.le.acquire()
        self.lo.acquire()

    # printNumber(x) outputs "x", where x is an integer.
    def zero(self, printNumber):
        """
        :type printNumber: method
        :rtype: void
        """
        for i in range(1, self.n + 1):
            self.lz.acquire()
            printNumber(0)
            self.lo.release() if i % 2 == 1 else self.le.release()

    def even(self, printNumber):
        """
        :type printNumber: method
        :rtype: void
        """
        for i in range(2, self.n + 1, 2):
            self.le.acquire()
            printNumber(i)
            self.cur += 1
            self.lz.release()


    def odd(self, printNumber):
        """
        :type printNumber: method
        :rtype: void
        """
        for i in range(1, self.n + 1, 2):
            self.lo.acquire()
            printNumber(i)
            self.cur += 1
            self.lz.release()


def printNumber(x):
    print(str(x))


if __name__ == "__main__":
    n = 3
    foo = ZeroEvenOdd(n)
    zero = threading.Thread(target=foo.zero(printNumber), name='zero')
    even = threading.Thread(target=foo.even(printNumber), name='even')
    odd = threading.Thread(target=foo.odd(printNumber), name='odd')
    zero.start()
    even.start()
    odd.start()
    zero.join()
    even.join()
    odd.join()