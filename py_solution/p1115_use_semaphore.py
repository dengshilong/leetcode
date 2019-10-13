import threading


class FooBar(object):
    def __init__(self, n):
        self.n = n
        self.sa = threading.Semaphore(1)
        self.sb = threading.Semaphore(0)

    def foo(self, printFoo):
        """
        :type printFoo: method
        :rtype: void
        """
        for i in range(self.n):
            # printFoo() outputs "foo". Do not change or remove this line.
            # print('lala')
            self.sa.acquire()
            # print('bbbb')
            printFoo()
            self.sb.release()
            # print('cccc')

    def bar(self, printBar):
        """
        :type printBar: method
        :rtype: void
        """
        for i in range(self.n):
            # printBar() outputs "bar". Do not change or remove this line.
            # print('lllll')
            self.sb.acquire()
            # print('aaaa')
            printBar()
            self.sa.release()


def printFoo():
    print('foo')


def printBar():
    print('bar')


if __name__ == "__main__":
    n = 10
    foo_bar = FooBar(n)
    foo = threading.Thread(target=foo_bar.foo(printFoo), name='foo')
    bar = threading.Thread(target=foo_bar.bar(printBar), name='bar')
    foo.start()
    bar.start()
    foo.join()
    bar.join()