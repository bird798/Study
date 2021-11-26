package com.pch.app.daggerstudy

import com.pch.app.daggerstudy.bind.DaggerBindComponent
import com.pch.app.daggerstudy.builder.BuilderTestModule
import com.pch.app.daggerstudy.builder.DaggerBuilderComponent
import com.pch.app.daggerstudy.cunstructor_inject.DaggerPersonComponent
import com.pch.app.daggerstudy.cunstructor_inject.PersonB
import com.pch.app.daggerstudy.cunstructor_inject.PersonC
import com.pch.app.daggerstudy.cunstructor_inject.PersonComponent
import com.pch.app.daggerstudy.factory.DaggerFactoryTestComponent
import com.pch.app.daggerstudy.lazy.Counter
import com.pch.app.daggerstudy.lazy.DaggerCounterComponent
import com.pch.app.daggerstudy.lazy_kot.Counter_Kot
import com.pch.app.daggerstudy.lazy_kot.DaggerCounterComponent_Kot
import com.pch.app.daggerstudy.member_injecttion.MyClass
import com.pch.app.daggerstudy.multibinding.DaggerIntoMapComponent
import com.pch.app.daggerstudy.multibinding.DaggerIntoSetComponent
import com.pch.app.daggerstudy.multibinding.DaggerMultibindsComponent
import com.pch.app.daggerstudy.multibinding.DaggerParentComponent
import com.pch.app.daggerstudy.named.DaggerNamedComponent
import com.pch.app.daggerstudy.named.NamedClass
import com.pch.app.daggerstudy.practice.DaggerPracticeComponent
import com.pch.app.daggerstudy.provider.Counter_Provider
import com.pch.app.daggerstudy.provider.DaggerCounterComponent_Provider
import com.pch.app.daggerstudy.provision_inject.DaggerMyComponent
import com.pch.app.daggerstudy.provision_inject.MyModule2
import com.pch.app.daggerstudy.provision_inject.Person
import com.pch.app.daggerstudy.qualifier.DaggerQualifierComponent
import com.pch.app.daggerstudy.qualifier.QualifierClass
import com.pch.app.daggerstudy.singleton.ContainerChild
import com.pch.app.daggerstudy.singleton.DaggerSingletonComponent
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testHelloWorld() {
        val myComponent = DaggerMyComponent.create();
        System.out.println("result = ${myComponent.getString()}")
        System.out.println("result = ${myComponent.getInt()}")
//        System.out.println("result = ${myComponent.getPerson()}")
    }

    @Test
    fun testMemberInjectionMethod() {
        val myClass = MyClass()
//
//        var str = myClass.getStr()
//        assertNotNull("조회 결과 null", str);   //  Null이 아님을 확인.

         val myComponent = DaggerMyComponent.create()
        myComponent.inject(myClass)
        var str = myClass.getStr()
        System.out.println("[testMemberInjectionMethod] result = ${str}")

        var person = myClass.getPerson()
        System.out.println("[testMemberInjectionMethod] person = ${person}")


        val myClass2 = MyClass()

        val injector = myComponent.getInject();
        injector.injectMembers(myClass2)
    }

    @Test
    fun testConstructInjection() {
        val personComponent : PersonComponent = DaggerPersonComponent.create()

        val personA = personComponent.getPersonA();
        System.out.println("personA (${personA.name} : ${personA.age})")

        val personD = personComponent.getPersonD();
        System.out.println("personD (${personD.name} : ${personD.age} : ${personD.gender})")


        val personB = PersonB()

        DaggerPersonComponent.create().inject(personB)
        System.out.println("personB (${personB.name} : ${personB.age})")

        val personC = PersonC()

        DaggerPersonComponent.create().inject(personC)
        System.out.println("personC (${personC.name} : ${personC.age} : ${personC.gender})")
    }

    @Test
    fun testBuilder() {
        val module2 = MyModule2()
        module2.setPerson(Person("sisi", 8))
        val component = DaggerBuilderComponent.builder()
            .setModule2(module2)
            .setMyModule(BuilderTestModule("wfewf")).build()

//        val newModule2 = component.getModule2()
        val testModule = component.getTestModule()
        val name = component.getName()
        System.out.println("testModule (${testModule.name}, ${name})")
//        val person = newModule2.person;
//        System.out.println("person (${person.name}, ${person.birthday})")
    }

    @Test
    fun testFactoty() {

        val component = DaggerFactoryTestComponent.factory().create(19791218);
        System.out.println("component (${component.getNumber()}, ${component.getString()})")
    }

    @Test
    fun testLazy() {
        val component = DaggerCounterComponent.create()
        val couter = Counter()
        component.inject(couter)
        couter.printLazy()
    }

    @Test
    fun testLazy_Kot() {
        val component = DaggerCounterComponent_Kot.create()
        val couter = Counter_Kot()
        component.inject(couter)
        couter.printLazy()
    }

    @Test
    fun testProvider() {
        val component = DaggerCounterComponent_Provider.create()
        val couter = Counter_Provider()
        component.inject(couter)
        couter.printProvider()
    }

    @Test
    fun testNamed() {
        val component = DaggerNamedComponent.create()
        var namedClass = NamedClass()
        component.inject(namedClass)

        System.out.println("namedClass (${namedClass.strHello}, ${namedClass.strWorld})")
    }

    @Test
    fun testQualifier() {
        val component = DaggerQualifierComponent.create()
        var clazz = QualifierClass()
        component.inject(clazz)

        System.out.println("QualifierClass (${clazz.strHello}, ${clazz.strWorld})")
    }

    @Test
    fun testSingleton() {
        val component = DaggerSingletonComponent.create()

        val obj1 = component.getAny();
        val obj2 = component.getAny();

        System.out.println("getAny (${obj1}, ${obj2})")

        val obj3 = component.getSingletonAny();
        val obj4 = component.getSingletonAny();

        System.out.println("getSingletonAny (${obj3}, ${obj4})")
    }

    @Test
    fun testBind() {
        val component = DaggerBindComponent.create()
        val bind = component.getIBind()
        System.out.println("bind (${bind.getPersonName()})")

        val bindClass1 = component.getBuindClass()
        System.out.println("bindClass1 (${bindClass1.getPersonName()})")
        val bindClass2 = component.getBuindClass2()
        System.out.println("bindClass2 (${bindClass2.getPersonName()})")
    }

    @Test
    fun testMultibinding() {
        val component = DaggerIntoSetComponent.create()

        val data = component.getStringSet();
        System.out.println("intoSet (${data.size}  ${data.toString()})")


        val component2 = DaggerIntoMapComponent.create()

        val data2 = component2.getLongsByString()
        System.out.println("intoMap (${data2.size}  $data2)")

        val data3 = component2.getStringByClass()
        System.out.println("intoMap (${data3.size}  $data3)")
    }

    @Test
    fun 테스트_상속바인딩() {
        val parentComponent = DaggerParentComponent.create();
        val childComponent = parentComponent.childCompBuilder().build()

        System.out.println("List set in parent")

        var itr = parentComponent.strings().iterator()
        while (itr.hasNext()) {
            System.out.println(itr.next())
        }

        System.out.println("List set in child")

        itr = childComponent.strings().iterator()
        while (itr.hasNext()) {
            System.out.println(itr.next())
        }
    }

    @Test
    fun 테스트_멀티바인딩() {
        val component = DaggerMultibindsComponent.create()
        val values = component.getStrings()

        System.out.println("테스트 멀티 바인딩!! values(${values.size} , $values")

    }

    @Test
    fun 테스트_연습() {

        val component = DaggerPracticeComponent.create()

        System.out.println("테스트 연습!! ${component.getContainer()}")
        System.out.println("테스트 연습!! ${component.getContainer()}")
        System.out.println("테스트 연습!! ${component.getContainer()}")
        System.out.println("테스트 연습!! ${component.getContainer()}")
    }

}