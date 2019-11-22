/*'''
Note: All attributes are implement as public since privately
inherited attributes are inaccessible*

    (*not really, they are just hidden)

'''
class Weapon(object):
    def __init__(self, name, damage):
        self.__name = name
        self.__damage = damage

    def __str__(self):
        msg = "*Name: {0} ({1})".format(self.__name, self.__class__.__name__)
        msg += "\n"
        msg += "*Damage: {}".format(self.__damage)
        return msg

    def getName(self):
        return self.__name

    def getDamage(self):
        return self.__damage

    def use(self):
        pass




class Knife(Weapon):
    def __init__(self, name, damage, throwable):
        super().__init__(name, damage)
        self.__throwable = throwable

    def __str__(self):
        msg = super().__str__()
        msg += "\nCan be thrown: {}".format(self.isThrowable())
        return msg

    def use(self):
        print("\tUsing {}".format(self.getName()))

    def isThrowable(self):
        return self.__throwable

    def throw(self):
        if (self.isThrowable() == True):
            print("\Throwing {}".format(self.getName()))
        else:
            print("\tKnife can't be thrown")



class Rifle(Weapon):
    def __init__(self, name, damage, numBullets):
        super().__init__(name, damage)
        self.__numBullets = numBullets

    def __str__(self):
        msg = super().__str__()
        msg += "\n**Number of Bullets: {}".format(self.__numBullets)
        return msg

    def use(self):
        if(self.__numBullets >= 3):
            self.__numBullets -= 3
            print("\tFiring {} (bullets: {})".format(self.getName(), self.__numBullets))
        else:
            print("\tOut of bullets")



def main():
    scar = Rifle("Scar", 50, 200)
    tKnife = Knife("Tactical Knife", 30, False)
    bKnife = Knife("Ballistic Knife", 50, True)


    tKnife.use()
    scar.use()
    scar.use()

    print(scar.getName() + " does " + str(scar.getDamage()) + " damage")
    print(tKnife.getName() + " does " + str(tKnife.getDamage()) + " damage")


main()
 */
public class Program {
	public static void main (String args[]) {
		Rifle scar = new Rifle("Scar", 50, 200);
		Knife tKnife = new Knife("Tactical Knife", 30, false);
		Knife bKnife = new Knife("Ballistic Knife", 50, true);


		tKnife.use();
		scar.use();
		scar.use();

		System.out.println(scar.getName() + " does " + scar.getDamage() + " damage");
		System.out.println(tKnife.getName() + " does " + tKnife.getDamage() + " damage");
	}
}
