<center> <h1>多态</h1> </center>

## 虚函数：
* 在类的定义中，前面有`virtual`关键字的成员函数就是虚函数。
* `virtual`关键字只用在类定义里的函数声明中，函数定义时不用写。

## 多态实现的关键： 虚函数表

* 每一个有虚函数的的类(或有虚函数的派生类)都有一个虚函数表。该类的任何对象中都存放着虚函数表的指针。  
* 虚函数表中列出了该类（没有基类）的虚函数地址。  
* 子类的数据区中也包含着父类的所有数据成员（包括虚函数表指针）。

```c++
class A {

};

class B {
    virtual int f();
};

class C : public B {

};
class D : virtual public A {

};
class E : virtual public B {

};
int main(int argc, char const *argv[])
{
    cout << sizeof(A) << endl;  //1
    cout << sizeof(B) << endl;  //8
    cout << sizeof(C) << endl;  //8
    cout << sizeof(D) << endl;  //8
    cout << sizeof(E) << endl;  //8
    return 0;
}
```

**多态的主要作用为：对继承体系中的所有类型都共通的行为和操作定义一个共同的接口。**  

