package com.self.ddyoung.daily.manager;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 17/3/22 下午3:42
 */
public class UserManager {

    public static int getBetweenRandom(int countA, int countB) {
        return getRandom(countB - countA) + countA;
    }

    public static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    public static String context = "爱慕与爱不同，爱慕因为有了仰慕的存在，转而显得更为纯粹，内省，也更为无私。这从郭襄真心为杨过夫妇团聚而祈福这件事中就能看得出来。在郭襄与杨过的关系中，郭襄一直处于主动的位置，主动奉献出爱，主动地为了杨过辗转反侧，从偶遇杨过后回到襄阳的一切表现中，我们可以看到郭襄是动了真感情的，她收藏神雕大侠的玩偶，为杨过祈福，因杨过为她做的一切欢欣鼓舞。那三件生日贺礼，表面上是为了贺寿，实际上却在借花献佛帮的是郭靖的忙。不能说杨过一点不爱郭襄，只能说是消受不起。一方面心中有人，另一方面，越是成熟的男人他的内心其实越是懦弱，在感情上尤是，他已经不可能全盘付出了，他没有那么多可以付出。郭襄却实实在在是无私的，甚至可说在她对杨过的感情上“慕”更大于“爱”，因为如果“爱”还有自私的一面的话，那么“慕”则完全是奉献的，直到掏空自己为止。这样飞蛾扑火式的情感，也只有处于花季时期的少女才会拥有，如此单纯，如此动人。";

    public static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = context.length();
        for (int i = 0; i < length; i++) {
            sb.append(context.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }
}
