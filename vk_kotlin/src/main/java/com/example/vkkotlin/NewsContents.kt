package com.example.vkkotlin

import java.util.*

object NewsContents {
    fun getNews(): ArrayList<News> {
        create()
        return news
    }

    private val news = ArrayList<News>()
    fun create() {
        val name1 = "Минимализм как стиль жизни"
        val name2 = "autopurification"
        val new10 = News(
            name2,
            "15 minutes ago",
            "    Настоящая красота идет изнутри и не зависит от возраста. (М.Монро)\n" +
                    "\n" +
                    "·   Красивые образы рождают красивые мысли, а красивые мысли ведут к красивым действиям. (Платон)\n" +
                    "\n" +
                    "·   Не та красива, у которой хвалят руку и ногу, а та, у кого весь облик не позволит восхищаться отдельными чертами. (Сенека)\n" +
                    "\n" +
                    "·   Красивым кажется все, на что смотришь с любовью. (Кристиан Моргенштерн)",
            5,
            1,
            2,
            15,
            R.drawable.picture,
            R.drawable.icon2,
            false
        )
        news.add(new10)
        var text =
            "Остановитесь перед каждым предметом, на который падает взгляд, и представьте, что он растворяется в воздухе, превращается во что-то другое, рассыпается в прах. Нет более приятного занятия, чем методично и непредвзято оценивать каждую вещь, с которой сталкиваешься в жизни: в чем ее польза, к какому универсуму она относится, какую ценность приносит в жизнь. Поймите, из каких элементов состоят эти вещи, сколько они прослужат и какие чувства вызывают.\n" +
                    "\n" +
                    "Из книги Доминик Лоро \"Искусство жить просто\"\n" +
                    "\n" +
                    "Книга на ЛитРес: https://www.litres.ru/8367940/?lfrom=223891309"
        val new1 = News(
            name1,
            "33 minutes ago",
            text,
            12,
            2,
            4,
            99,
            R.drawable.pic1,
            R.drawable.icon1,
            false
        )
        news.add(new1)
        text = "Нет строгих и конкретных правил для минимализма.\n" +
                "\n" +
                "Для одних это может быть матрас, ноутбук и немного одежды, для других — это упорядоченные полки с вещами в 100 комнатах.\n" +
                "\n" +
                "Минимализм — означает минимум, но этот минимум у каждого разный. То есть вполне допустимо, чтобы вы имели не 50 личных вещей, а 150 000, но эти вещи, должны размещаться в определенном, удовлетворяющем ваши потребности, порядке. Хотя стоит учесть — что просто невозможно использовать все 150 тыс. вещей, даже изредка. А неиспользуемые вещи — превращаются в «мебель» или «хлам», и по сути вам не нужны."
        val new2 = News(
            name1,
            "59 minutes ago",
            text,
            426,
            1,
            29,
            560,
            R.drawable.pic2,
            R.drawable.icon1,
            false
        )
        news.add(new2)
        text = "Back-to-school\n" +
                "руководство по поддержанию психического здоровья\n" +
                "\n" +
                "• сделай перестановку в комнате\n" +
                "• поспи\n" +
                "• позволь себе плакать\n" +
                "• составь новый плейлист\n" +
                "• сходи на прогулку после занятий\n" +
                "• найди книги и подкасты, которыми будешь наслаждаться по вечерам\n" +
                "• поговори с другом, которому доверяешь\n" +
                "\n" +
                "помни\n" +
                "\n" +
                "• ты не одна\n" +
                "• другие тоже это чувствуют\n" +
                "• предложи новеньким сидеть с тобой во время обеда\n" +
                "• не каждая дружба будет длиться вечно\n" +
                "• будь добра ко всем, у каждой своя история\n" +
                "• ты многим можешь поделиться"
        val new3 = News(
            name2,
            "today at 19:08",
            text,
            612,
            50,
            11,
            999,
            R.drawable.pic3,
            R.drawable.icon2,
            false
        )
        news.add(new3)
        text =
            "Как стать минималистом? Начиная серьезную работу освобождения себя от всего ненужного, человеку следует исключить из обихода такие навязанные ему маркетологами штампы, как, «в новую жизнь – со всем новым» или «экономь, покупая больше (или «покупая сейчас», «до такого-то числа» и др.)». Всё это придумано для увеличения выручки торговых компаний и не отвечает истинным потребностям людей.\n" +
                    "\n" +
                    "Новая жизнь начинается не тогда, когда дорогое заменяется дешёвым, а когда человек перестает цепляться за привитый ему обществом инстинкт накопления. Это значит научиться отделять то, что необходимо (например, осенние туфли), от того, без чего легко можно обойтись, но что ошибочно представляется необходимым (3-4 пары осенних туфель под цвет одежды)."
        val new4 = News(
            name1,
            "today at 13:54",
            text,
            136,
            68,
            2,
            320,
            R.drawable.pic4,
            R.drawable.icon1,
            false
        )
        news.add(new4)
        text = "Как понять, что нужны перемены\n" +
                "\n" +
                "Чтобы понять, насколько близко или далеко человек находится от идеалов минимализма, ему нужно ответить на три вопроса:\n" +
                "\n" +
                "1. Есть ли в его гардеробе одежда (обувь), которую он не надевал больше года и не планирует носить в ближайшие 3 месяца?\n" +
                "2. Вызывает ли уборка в доме раздражение из-за обилия предметов, находящихся «не на том месте»?\n" +
                "3. Часто ли у него возникает ощущение мысленного хаоса и проблемы из-за невозможности сосредоточиться?\n" +
                "\n" +
                "Если на два из трех предложенных вопросов ответ будет «да», значит, «вещевая паника» уже прочно вошла в жизнь, и избавиться от неё можно, только следуя основным принципам минимализма."
        val new5 = News(
            name1,
            "yesterday at 7:37",
            text,
            188,
            53,
            60,
            206,
            R.drawable.pic5,
            R.drawable.icon1,
            false
        )
        news.add(new5)
        text = "сис, пришло время снова быть счастливыми"
        val new6 = News(
            name2,
            "yesterday at 13:59",
            text,
            785,
            96,
            14,
            942,
            R.drawable.pic6,
            R.drawable.icon2,
            false
        )
        news.add(new6)
        text = "То, что поможет пережить тяжёлый период\n" +
                "\n" +
                "• поговорить с кем-то, кто не станет осуждать\n" +
                "• уютная обстановка\n" +
                "• одеялки\n" +
                "• дополнительный сон\n" +
                "• выплакаться\n" +
                "• любимый сериал\n" +
                "• разминка\n" +
                "• горячая ванна\n" +
                "• грелка\n" +
                "• друг, которому можно рассказать о своих чувствах\n" +
                "• пижама\n" +
                "• травяной чай"
        val new7 = News(
            name2,
            "23 February at 17:35",
            text,
            158,
            21,
            41,
            459,
            R.drawable.pic7,
            R.drawable.icon2,
            false
        )
        news.add(new7)
        text =
            "Меня всегда удивляло, почему люди говорят, что они устраивают праздник в честь своего дня рождения. Как можно чествовать день? Разве у дня есть чувства? Он вообще знает, что вы устраиваете праздник в его честь?\n" +
                    "Устраивайте праздник в честь себя, а не дня рождения. И чевствуйте себя так каждый день!"
        val new8 = News(
            name2,
            "24 February at 17:17",
            text,
            926,
            26,
            1,
            994,
            R.drawable.pic8,
            R.drawable.icon2,
            false
        )
        news.add(new8)
        text =
            "Способность к процветанию определяется нашими убеждениями и не имеет никакого отношения ни к системе оплаты труда, ни к размеру зарплаты. Взять, например, человек восемь, которые трудятся в одной и той же компании и получают одинаковые деньги. И обнаружится, что часть из них удачно вложили свои деньги и живут припеваючи, а некоторым приходится бегать за кредитом в банк каждый раз, когда хочется съесть бутерброд. И отличаются эти люди друг от друга не заработком, а отношением к деньгам. Если получаешь не столько денег, сколько хотел бы, или если они постоянно куда-то деваются, на то есть причина. И корень ее – вовсе не в окружающем мире, а в твоем внутреннем.\n" +
                    "\n" +
                    "Из книги Эндрю Мэтьюза \"Живи легко!\""
        val new9 = News(
            name1,
            "24 February at 16:11",
            text,
            729,
            13,
            32,
            956,
            R.drawable.pic9,
            R.drawable.icon1,
            false
        )
        news.add(new9)
    }

}