import threading


class ZeroEvenOdd(object):
    def __init__(self, n):
        self.n = n
        self.sz = threading.Semaphore(1)
        self.se = threading.Semaphore(0)
        self.so = threading.Semaphore(0)
        self.cur = 1

    # printNumber(x) outputs "x", where x is an integer.
    def zero(self, printNumber):
        """
        :type printNumber: method
        :rtype: void
        """
        for i in range(1, self.n + 1):
            self.sz.acquire()
            printNumber(0)
            self.so.release() if i % 2 == 1 else self.se.release()

    def even(self, printNumber):
        """
        :type printNumber: method
        :rtype: void
        """
        for i in range(2, self.n + 1, 2):
            self.se.acquire()
            printNumber(i)
            self.cur += 1
            self.sz.release()


    def odd(self, printNumber):
        """
        :type printNumber: method
        :rtype: void
        """
        for i in range(1, self.n + 1, 2):
            self.so.acquire()
            printNumber(i)
            self.cur += 1
            self.sz.release()


def printNumber(x):
    print(str(x))


if __name__ == "__main__":
    n = 3
    foo = ZeroEvenOdd(n)
    zero = threading.Thread(target=foo.zero, args=(printNumber,))
    even = threading.Thread(target=foo.even, args=(printNumber,))
    odd = threading.Thread(target=foo.odd, args=(printNumber,))
    zero.start()
    even.start()
    odd.start()
    zero.join()
    even.join()
    odd.join()