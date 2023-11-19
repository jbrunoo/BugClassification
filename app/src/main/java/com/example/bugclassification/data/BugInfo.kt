package com.example.bugclassification.data

enum class BugInfo(
    val type: String,
    val title: String,
    val information: String,
    val habitat: String,
    val prevention: String,
    val extermination: String
) {
    ANT(
        "개미",
        "벌목",
        "개미의 몸은 일반적으로 머리 · 가슴 · 배로 나누어져 있으며 더듬이가 있다." +
                " 턱은 잘 발달되어 튼튼하며 종류에 따라 다소 변한다. 다리는 3쌍이다." +
                " 배 끝에서 포름산을 배출하는 것이 많은데, 침개미나 유랑개미 같은 종류는 독침을 가지고 있다.",
        "열대성 개미로 온도 27~30℃, 습도 70% 정도인 곳을 서식지로 삼습니다." +
                " 실내의 벽, 천장 틈새, 가구, 마루 밑 등에서 서식하는 것을 선호합니다. " +
                "군체에 여왕개미가 수백 마리가 존재하며 내부의 수개미와 동종 교미를 합니다. " +
                "한 군체의 개체가 많아지거나 주위 환경이 악화되면 다른 곳으로 분산도 됩니다. " +
                "집안 내 들어오는 택배 상자나 가구 등에 이동하는 경향이 있으며, " +
                "적절한 수분이 있어야 하므로 주방 및 화장실 주변에 서식처를 정합니다.",
        "집안을 항상 깨끗하게 청소하고 음식 부스러기를 치워 음식 냄새를 막습니다. " +
                "식품을 보관할 때는 밀봉 용기를 사용하여 개미의 침입을 막습니다.",
        "개미의 이동경로를 파악하고 개미가 통과하지 못하도록 장애물을 설치합니다. " +
                "식품 저장 공간 주변에 밀봉된 개미 퇴치용 덫을 설치하여 개미를 잡아냅니다. " +
                "식초, 사이다, 식기 세제 등의 소독제를 사용합니다. 페퍼민트 오일, 향균제, 살충제 등을 사용합니다. " +
                "창문, 문 주위 점검 및 실리콘 봉합제를 사용합니다. " +
                "위 방법으로 해결할 수 없는 경우 전문적인 방제 서비스를 이용합니다."
    ),
    SPIDER(
        "거미",
        "거미목",
        "집에서 출몰하는 거미는 꼬마거미류, 늑대거미류, 깡충거미류, 들풀거미, 유령거미, 게거미, 깔때기거미, 아롱가죽거미 등이 있습니다.",
        "거미는 현관이나 창문틈을 통해서 유입됩니다.\n" +
                "사람 손이 잘 닿지 않는 곳이나 청소가 미흡하면 거미가 출몰할 수 있습니다.\n" +
                "베란다나 세탁기 밑, 집안 구석 등 신경 써서 청소해주시면 충분히 예방하실 수 있습니다.",
        "사람 손이 잘 닿지 않는 곳이나 청소가 미흡하면 거미가 출몰할 수 있습니다.\n" +
                "베란다나 세탁기 밑, 집안 구석 등 신경 써서 청소하면 예방할 수 있습니다.",
        "거미줄제거 및 성충제거 거미가 싫어하는 계피, 민트향 허브 등을 사용합니다." +
                "거미는 단체 서식을 하는 동물이 아니기 때문에 잡거나 방생, 살충제를 사용합니다.",
    ),
    CIGAR_BEETLE(
        "권연벌레",
        "딱정벌레목",
        "권연벌레는 2~4mm 정도의 크기로 매우 작으며 보통 벽이나 바닥에서 기어 다니는 모습으로 발견할 수 있습니다.",
        "사람 손이 닿거나 위험하다고 느끼는 순간에는 죽은 척을 하다가 날아가 버릴 수 있습니다.",
        "고온다습한 서식처에서 잘 적응하는 습성이 있어 주로 여름이나 장마철에 많이 발생하는 해충입니다.\n" +
                "야행성이어서 주로 흐린 날과 초저녁에 활발하게 움직이는 습성이 있습니다.",
        "음식물을 완전히 밀폐해서 보관합니다." +
                "곡물, 밀가루, 건어물, 사료 등 권연벌레 서식지를 찾고 없애주는 것이 중요합니다." +
                "제습기를 이용하거나 환기를 해서 실내 습도를 낮춰 줍니다." +
                "마늘 냄새를 정말 싫어하기 때문에 마늘을 걸어두거나 마늘과 물을 1:1 비율로 섞어 뿌려줍니다.",
    ),
    CEPHALONOMIA_GALLICOLA(
        "권연침벌", "벌목",
        "권연침벌은 크기가 1~2mm 정도의 작은 곤충으로 개미를 닮은 곤충입니다." +
                "기생성 곤충으로 딱정벌레류 중에서도 인삼벌레, 권연벌레 유충에 기생을 하는 습성이 있습니다.",
        "권연벌레 따위의 숙주의 무리가 있는 곳에 서식한다." +
                "책과 드라이플라워 등에서 서식하지만 침대나 패브릭 소파 등 침구류에서도 목격됩니다.",
        "권연벌레의 예방법과 동일하다.",
        "권연침벌의 숙주인 권연벌레를 찾아 퇴치합니다." +
                "살충제를 통해 권연침벌을 퇴치합니다." +
                "",
    ),
    HOUSE_CENTIPEDE(
        "그리마",
        "그리마목",
        "그리마는 몸길이가 약 1~2cm 정도의 작은 곤충입니다. 몸은 납작하고, 색깔은 갈색이나 검은색을 띠고 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 주둥이가 있어서 식물의 즙이나 과일을 먹습니다.\n" +
                "\n" +
                "그리마는 사람에게 해를 끼치지는 않지만, 보기 흉하고 불쾌감을 줄 수 있습니다. 또한, 그리마의 배설물이나 알에는 알레르기를 유발할 수 있는 물질이 포함되어 있습니다.",
        "그리마는 다양한 환경에서 서식할 수 있지만, 일반적으로 따뜻하고 습한 환경을 좋아합니다. 따라서 주로 숲, 풀밭, 정원, 화장실, 욕실, 주방, 옷장, 서랍 등과 같이 따뜻하고 습한 곳에 서식합니다. 또한, 음식물 쓰레기나 곰팡이 등이 있는 곳에서도 서식합니다.",
        "주기적으로 청소를 하고, 습기를 제거합니다.\n" +
                "음식물 쓰레기를 자주 버리고, 깨끗하게 치웁니다.\n" +
                "곰팡이가 생기지 않도록 합니다.\n" +
                "음식물을 보관할 때는 밀폐 용기에 담아 그리마가 접근하지 못하도록 합니다.",
        "그리마를 먼지떨이로 털어내거나, 흡입기로 빨아들입니다.\n" +
                "그리마를 잡아서 죽입니다."
    ),
    MOTH(
        "나방",
        "나비목",
        "나방은 몸길이가 약 1~10cm 정도의 다양한 크기를 가진 곤충입니다. 몸은 털이 많고, 색깔은 갈색이나 검은색을 띠고 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 주둥이가 있어서 식물의 즙이나 과일을 먹습니다.\n" +
                "\n" +
                "나방은 사람에게 해를 끼치지는 않지만, 보기 흉하고 불쾌감을 줄 수 있습니다. 또한, 나방의 배설물이나 알에는 알레르기를 유발할 수 있는 물질이 포함되어 있습니다.",
        "나방은 다양한 환경에서 서식할 수 있지만, 일반적으로 따뜻하고 어두운 환경을 좋아합니다. 따라서 주로 숲, 풀밭, 정원, 화장실, 욕실, 주방, 옷장, 서랍 등과 같이 따뜻하고 어두운 곳에 서식합니다. 또한, 음식물 쓰레기나 곰팡이 등이 있는 곳에서도 서식합니다.",
        "주기적으로 청소를 하고, 습기를 제거합니다.\n" +
                "음식물 쓰레기를 자주 버리고, 깨끗하게 치웁니다.\n" +
                "곰팡이가 생기지 않도록 합니다.\n" +
                "음식물을 보관할 때는 밀폐 용기에 담아 나방이 접근하지 못하도록 합니다.",
        "나방을 먼지떨이로 털어내거나, 흡입기로 빨아들입니다.\n" +
                "나방을 잡아서 죽입니다."
    ),
    MOTH_FLY(
        "나방파리",
        "파리목",
        "나방파리는 몸길이가 약 1~5cm 정도의 작은 곤충입니다. 몸은 가늘고 길며, 색깔은 갈색이나 검은색을 띠고 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 주둥이가 있어서 식물의 즙이나 동물의 피를 빨아먹습니다.\n" +
                "\n" +
                "나방파리는 사람의 피를 빨아먹는 흡혈성 곤충입니다. 나방파리가 사람을 물면, 나방파리의 침에 들어 있는 독성 물질로 인해 가려움증과 통증이 생길 수 있습니다. 또한, 나방파리는 기생충을 옮기는 매개체가 될 수 있습니다.\n",
        "나방파리는 따뜻하고 습한 환경을 좋아합니다. 따라서 주로 숲, 풀밭, 정원, 화장실, 욕실, 주방, 옷장, 서랍 등과 같이 따뜻하고 습한 곳에 서식합니다. 또한, 음식물 쓰레기나 곰팡이 등이 있는 곳에서도 서식합니다.",
        "주기적으로 청소를 하고, 습기를 제거합니다.\n" +
                "음식물 쓰레기를 자주 버리고, 깨끗하게 치웁니다.\n" +
                "곰팡이가 생기지 않도록 합니다.\n" +
                "음식물을 보관할 때는 밀폐 용기에 담아 나방파리가 접근하지 못하도록 합니다.",
        "창문이나 문틈에 방충망을 설치하여 나방파리가 들어오지 못하도록 합니다.\n" +
                "주방이나 화장실은 청결하게 유지하여 나방파리가 서식할 수 있는 환경을 만들지 않습니다.\n" +
                "위와 같은 방법을 실천하면 나방파리 피해를 예방하고, 쾌적한 환경을 유지할 수 있습니다."
    ),
    WEEVIL(
        "바구미",
        "딱정벌레목",
        "바구미는 몸길이가 약 2~5mm 정도의 작은 벌레입니다. 몸은 갈색이나 검은색을 띠고 있으며, 날개가 있는 종류와 없는 종류가 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 빨판 모양의 빨판이 있어서 음식물을 빨아먹습니다.\n" +
                "\n" +
                "바구미는 곡물이나 견과류, 씨앗, 건조 과일, 건조 육류, 가공식품 등의 식물성 플랑크톤이나 음식물 쓰레기 등을 먹고 삽니다.",
        "바구미는 따뜻하고 건조한 환경을 좋아합니다. 따라서 주로 곡물이나 견과류, 씨앗, 건조 과일, 건조 육류, 가공식품, 의류, 가구 등과 같이 건조한 곳에 서식합니다.",
        "곡물이나 견과류, 씨앗, 건조 과일, 건조 육류, 가공식품 등을 밀폐 용기에 담아 보관합니다.\n" +
                "옷장이나 서랍 등에는 방충제를 사용합니다.\n" +
                "주기적으로 청소를 하고, 습기를 제거합니다.",
        "바구미가 발견된 곳을 청소기로 빨아들입니다.\n" +
                "바구미가 싫어하는 향을 사용합니다.\n" +
                "바구미약을 사용하여 바구미를 죽입니다.\n" +
                "바구미는 사람에게 해를 끼치지는 않지만, 음식물이나 의류 등을 망가뜨릴 수 있습니다. 따라서 위와 같은 방법으로 예방하고, 피해를 받았을 때는 빠르게 처치하는 것이 좋습니다.",
    ),
    COCKROACH(
        "바퀴벌레",
        "바퀴목",
        "바퀴벌레는 몸길이가 약 1~5cm 정도의 작은 곤충입니다. 몸은 갈색이나 검은색을 띠고 있으며, 날개가 있는 종류와 없는 종류가 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 빨판 모양의 빨판이 있어서 음식물을 빨아먹습니다.\n" +
                "\n" +
                "바퀴벌레는 식물성 플랑크톤이나 음식물 쓰레기, 곰팡이 등을 먹고 삽니다.",
        "바퀴벌레는 따뜻하고 습한 환경을 좋아합니다. 따라서 주로 주방, 화장실, 욕실, 다용도실, 옷장, 서랍 등과 같이 따뜻하고 습한 곳에 서식합니다. 또한, 음식물 쓰레기나 곰팡이 등이 있는 곳에서도 서식합니다.\n",
        "주기적으로 청소를 하고, 습기를 제거합니다.\n" +
                "음식물 쓰레기를 자주 버리고, 깨끗하게 치웁니다.\n" +
                "곰팡이가 생기지 않도록 합니다.\n" +
                "음식물을 보관할 때는 밀폐 용기에 담아 바퀴벌레가 접근하지 못하도록 합니다.",
        "바퀴벌레가 발견된 곳을 청소기로 빨아들입니다.\n" +
                "바퀴벌레가 싫어하는 향을 사용합니다.\n" +
                "바퀴벌레약을 사용하여 바퀴벌레를 죽입니다.\n" +
                "바퀴벌레는 사람에게 해를 끼칠 수 있으므로, 위와 같은 방법으로 예방하고, 피해를 받았을 때는 빠르게 처치하는 것이 좋습니다."
    ),
    FLY(
        "파리",
        "파리목",
        "파리는 몸길이가 약 6~12mm 정도의 작은 곤충입니다. 몸은 검은색이나 갈색을 띠고 있으며, 날개가 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 빨판 모양의 빨판이 있어서 음식물을 빨아먹습니다.\n" +
                "\n" +
                "파리는 식물성 플랑크톤이나 썩은 음식물, 동물의 배설물 등을 먹고 삽니다.",
        "파리는 따뜻하고 습한 환경을 좋아합니다. 따라서 주로 여름철에 많이 번식하고, 주로 음식물 쓰레기나 썩은 음식물 등이 있는 곳에서 서식합니다. 또한, 동물의 배설물이나 습기가 많은 곳에서도 서식합니다.",
        "음식물 쓰레기를 자주 버리고, 깨끗하게 치웁니다.\n" +
                "썩은 음식물이나 동물의 배설물을 즉시 처리합니다.\n" +
                "화장실이나 욕실은 환기를 자주 시킵니다.\n" +
                "파리가 싫어하는 향을 사용합니다. 예를 들어, 계피, 바닐라, 박하, 라벤더 등의 향을 사용하면 파리가 멀어집니다. 창문이나 문틈에 방충망을 설치하여 파리가 들어오지 못하도록 합니다.\n" +
                "음식물을 보관할 때는 밀폐 용기에 담아 파리가 접근하지 못하도록 합니다.\n" +
                "주방이나 화장실은 청결하게 유지하여 파리가 서식할 수 있는 환경을 만들지 않습니다.\n" +
                "위와 같은 방법을 실천하면 파리 피해를 예방하고, 쾌적한 환경을 유지할 수 있습니다.",
        "파리를 잡아 죽입니다.\n" +
                "파리채나 파리끈을 사용하여 파리를 잡습니다.\n" +
                "파리약을 사용하여 파리를 죽입니다.\n" +
                "파리는 식중독을 일으키는 세균을 옮길 수 있으므로, 파리 피해를 받았을 때는 빠르게 처치하는 것이 좋습니다."
    ),
    BOOKLICE(
        "먼지다듬이",
        "다듬이벌레목",
        "먼지다듬이는 몸길이가 약 1~2mm 정도의 작은 벌레입니다. 몸은 납작하고, 색깔은 갈색이나 검은색을 띠고 있습니다. 머리에는 2개의 촉각이 있고, 가슴에는 3쌍의 다리가 있습니다. 또한, 날개가 없는 것이 특징입니다.",
        "먼지다듬이는 습하고 어두운 환경을 좋아합니다. 따라서 주로 화장실, 욕실, 다용도실, 옷장, 서랍, 책상 밑 등과 같이 습기가 많은 곳에 서식합니다. 또한, 먼지와 부스러기가 많은 곳을 좋아하여, 청소가 소홀한 곳에서 많이 발견됩니다.",
        "주기적으로 청소를 하고, 습기를 제거합니다." +
                "먼지와 부스러기가 쌓이지 않도록 합니다." +
                "옷장이나 서랍은 자주 열어 환기를 시킵니다." +
                "화장실과 욕실은 습기가 차지 않도록 환기를 자주 시킵니다.",
        "먼지다듬이가 발견된 곳을 청소기로 빨아들입니다." +
                "먼지다듬이가 싫어하는 향을 사용합니다. 예를 들어, 계피, 바닐라, 박하, 라벤더 등의 향을 사용하면 먼지다듬이가 멀어집니다.\n" +
                "먼지다듬이를 잡아 죽입니다." +
                "먼지다듬이는 사람에게 해를 끼치지는 않지만, 보기 흉하고 불쾌감을 줄 수 있습니다. " +
                "따라서 위와 같은 방법으로 예방하고, 피해를 받았을 때는 빠르게 처치하는 것이 좋습니다."
    ),
    MOSQUITO(
        "모기",
        "파리목",
        "모기는 몸길이가 약 2~10mm 정도의 작은 곤충입니다. 몸은 갈색이나 검은색을 띠고 있으며, 날개가 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 빨판 모양의 빨판이 있어서 피를 빨아먹습니다.\n" +
                "\n" +
                "모기는 사람의 피를 빨아먹을 때 침을 주입하는데, 이 침에 들어 있는 독성 물질로 인해 가려움증과 발진이 생길 수 있습니다. 또한, 모기는 말라리아, 뎅기열, 지카 바이러스병 등과 같은 질병을 옮길 수 있습니다.",
        "모기는 따뜻하고 습한 환경을 좋아합니다. 따라서 주로 물가나 숲, 늪지대, 축사, 하수구 등과 같이 따뜻하고 습한 곳에 서식합니다. 또한, 물웅덩이나 우물, 배수로 등과 같은 곳에 알을 낳습니다.\n",
        "\n" +
                "물웅덩이나 우물, 배수로 등과 같은 곳에는 물을 채우지 않도록 합니다.\n" +
                "집 주변의 풀이나 나무를 정리하여 모기가 서식할 수 있는 환경을 만들지 않습니다.\n" +
                "창문이나 문틈에 방충망을 설치하여 모기가 들어오지 못하도록 합니다.\n" +
                "모기 기피제를 사용합니다.\n" +
                "모기에 물렸을 경우 다음과 같은 방법으로 처치합니다.\n" +
                "\n" +
                "물린 부위를 깨끗하게 씻습니다.\n" +
                "얼음찜질을 합니다.\n" +
                "항히스타민제를 복용합니다.\n" +
                "모기에 물렸을 경우 붉은 반점이나 발열, 두통 등의 증상이 나타날 수 있습니다. 이러한 증상이 나타나면 병원을 방문하여 진료를 받는 것이 좋습니다.",
        "야외 활동 시 긴 소매와 긴 바지를 착용합니다.\n" +
                "모기 기피제 사용 시 옷과 피부에 골고루 바릅니다.\n" +
                "모기가 서식할 수 있는 환경을 만들지 않도록 주기적으로 청소합니다.\n" +
                "위와 같은 방법을 실천하면 모기 피해를 예방하고, 쾌적한 환경을 유지할 수 있습니다."
    ),
    BED_BUG(
        "빈대",
        "노린재목",
        "빈대는 몸길이가 약 2~5mm 정도의 작은 벌레입니다. 몸은 타원형이고, 색깔은 붉은색이나 갈색을 띠고 있습니다. 머리에는 2개의 촉각이 있고, 가슴에는 3쌍의 다리가 있습니다. 또한, 날개가 없는 것이 특징입니다.\n" +
                "\n" +
                "빈대는 사람의 피를 빨아먹을 때 침을 주입하는데, 이 침에 들어 있는 독성 물질로 인해 가려움증과 발진이 생길 수 있습니다.",
        "빈대는 따뜻하고 어두운 환경을 좋아합니다. 따라서 주로 침대, 매트리스, 소파, 옷장, 서랍, 책상 밑 등과 같이 어둡고 틈새가 많은 곳에 서식합니다. 또한, 사람의 피를 주로 먹고 삽니다.",
        "빈대를 예방하기 위해서는 다음과 같은 방법을 실천합니다.\n" +
                "침대, 매트리스, 소파, 옷장, 서랍, 책상 밑 등은 주기적으로 청소를 하고, 습기를 제거합니다.\n" +
                "침대와 매트리스는 빈대가 서식할 수 있는 틈새를 막아줍니다.\n" +
                "침대와 매트리스는 빈대가 서식하지 못하도록 방수커버를 사용합니다.\n" +
                "침구는 자주 세탁하고, 건조시킵니다.\n" +
                "여행을 다녀온 후에는 침구를 깨끗하게 세탁하고, 건조시킵니다.\n" +
                "빈대가 서식할 가능성이 있는 물건을 구입할 때는 주의합니다.\n" +
                "빈대 피해가 발생한 경우 전문업체에 의뢰하여 처리하는 것이 좋습니다.\n" +
                "위와 같은 방법을 실천하면 빈대 피해를 예방하고, 쾌적한 환경을 유지할 수 있습니다.",
        "빈대가 발견된 침대, 매트리스, 소파, 옷장, 서랍, 책상 밑 등은 빈대가 서식하지 못하도록 처리합니다.\n" +
                "빈대가 발견된 곳을 청소기로 빨아들입니다.\n" +
                "빈대가 싫어하는 향을 사용합니다.\n" +
                "빈대는 사람에게 해를 끼칠 수 있으므로, 위와 같은 방법으로 예방하고, 피해를 받았을 때는 빠르게 처치하는 것이 좋습니다."
    ),
    SILVERFISH(
        "좀벌레",
        "좀목",
        "좀벌레는 몸길이가 약 2~4mm 정도의 작은 벌레입니다. 몸은 납작하고, 색깔은 갈색이나 검은색을 띠고 있습니다. 머리에는 2개의 촉각이 있고, 가슴에는 3쌍의 다리가 있습니다. 또한, 날개가 없는 것이 특징입니다.\n" +
                "\n" +
                "좀벌레는 옷감이나 가죽, 종이, 나무 등 유기물을 먹고 삽니다.",
        "좀벌레는 따뜻하고 습한 환경을 좋아합니다. 따라서 주로 옷장, 서랍, 책상 밑, 벽지, 가구 등과 같이 습기가 많은 곳에 서식합니다. 또한, 옷감이나 가죽, 종이, 나무 등 유기물을 먹고 삽니다.\n",
        "옷장이나 서랍, 책상 밑 등은 주기적으로 청소를 하고, 습기를 제거합니다.\n" +
                "옷감이나 가죽, 종이, 나무 등 유기물을 밀폐 용기에 담아 보관합니다.\n" +
                "옷장이나 서랍, 책상 밑 등에는 좀벌레가 싫어하는 향을 사용합니다. 예를 들어, 계피, 바닐라, 박하, 라벤더 등의 향을 사용하면 좀벌레가 멀어집니다.",
        "좀벌레가 발견된 물건을 버립니다.\n" +
                "좀벌레가 발견된 곳을 청소기로 빨아들입니다.\n" +
                "좀벌레가 싫어하는 향을 사용합니다.\n" +
                "좀벌레는 사람에게 해를 끼치지는 않지만, 옷이나 가구 등을 망가뜨릴 수 있습니다. 따라서 위와 같은 방법으로 예방하고, 피해를 받았을 때는 빠르게 처치하는 것이 좋습니다."
    ),
    SOW_BUG(
        "쥐며느리", "등각목",
        "쥐며느리는 몸길이가 약 2~3cm 정도의 작은 벌레입니다. 몸은 납작하고, 색깔은 회색이나 갈색을 띠고 있습니다. 머리에는 2개의 촉각이 있고, 가슴에는 4개의 다리가 있습니다. 또한, 몸통에는 4쌍의 흡반이 있어서 움직입니다.\n" +
                "\n" +
                "쥐며느리는 식물성 플랑크톤이나 곰팡이, 음식물 쓰레기 등을 먹고 삽니다.",
        "쥐며느리는 습하고 어두운 환경을 좋아합니다. 따라서 주로 화장실, 욕실, 다용도실, 옷장, 서랍, 책상 밑 등과 같이 습기가 많은 곳에 서식합니다. 또한, 음식물 쓰레기나 곰팡이 등이 있는 곳에서도 서식합니다.",
        "주기적으로 청소를 하고, 습기를 제거합니다.\n" +
                "음식물 쓰레기를 자주 버리고, 깨끗하게 치웁니다.\n" +
                "곰팡이가 생기지 않도록 합니다.\n" +
                "옷장이나 서랍은 자주 열어 환기를 시킵니다.",
        "쥐며느리가 발견된 곳을 청소기로 빨아들입니다.\n" +
                "쥐며느리가 싫어하는 향을 사용합니다. 예를 들어, 계피, 바닐라, 박하, 라벤더 등의 향을 사용하면 쥐며느리가 멀어집니다.\n" +
                "쥐며느리를 잡아 죽입니다.\n" +
                "쥐며느리는 사람에게 해를 끼치지는 않지만, 보기 흉하고 불쾌감을 줄 수 있습니다. 따라서 위와 같은 방법으로 예방하고, 피해를 받았을 때는 빠르게 처치하는 것이 좋습니다.",
    ),
    MITE(
        "진드기",
        "진드기상목",
        "진드기는 몸길이가 약 0.2~1cm 정도의 작은 곤충입니다. 몸은 타원형이고, 색깔은 갈색이나 검은색을 띠고 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 빨판 모양의 빨판이 있어서 피를 빨아먹습니다.\n" +
                "\n" +
                "진드기는 사람에게 다양한 질병을 옮길 수 있습니다. 대표적인 질병으로는 라임병, 세균성뇌막염, 쯔쯔가무시병 등이 있습니다.",
        "진드기는 따뜻하고 습한 환경을 좋아합니다. 따라서 주로 야외에서 풀이나 덤불이 우거진 곳에서 서식합니다. 또한, 동물의 몸에 기생하기도 합니다.",
        "야외활동 시 긴 소매와 긴 바지를 착용합니다.\n" +
                "모기 기피제를 사용합니다.\n" +
                "야외활동 후에는 옷과 몸을 꼼꼼하게 살펴봅니다.\n" +
                "동물의 몸에 기생한 진드기가 있는지 확인합니다.\n" +
                "진드기 피해를 받았을때의 처치방법",
        "\n" +
                "집 주변의 풀이나 덤불을 정리합니다.\n" +
                "동물의 몸에 기생한 진드기를 발견하면 바로 제거합니다.\n" +
                "진드기에 물렸을 경우 의심 증상이 나타나지 않더라도 병원을 방문하여 진료를 받는 것이 좋습니다.\n" +
                "위와 같은 방법을 실천하면 진드기 피해를 예방하고, 건강을 지킬 수 있습니다."
    ),
    EARWIG(
        "집게벌레",
        "집게벌레목",
        "집게벌레는 몸길이가 약 1~2cm 정도의 작은 곤충입니다. 몸은 갈색이나 검은색을 띠고 있으며, 집게 모양의 다리가 있습니다. 머리에는 2개의 촉각과 2개의 눈이 있습니다. 또한, 입에는 빨판 모양의 빨판이 있어서 음식물을 빨아먹습니다. 집게벌레는 식물성 플랑크톤이나 곰팡이, 음식물 쓰레기 등을 먹고 삽니다.",
        "집게벌레는 따뜻하고 습한 환경을 좋아합니다. 따라서 주로 여름철에 많이 번식하고, 주로 부엌, 욕실, 화장실, 다용도실, 옷장, 서랍 등과 같이 습기가 많은 곳에 서식합니다. 또한, 음식물 쓰레기나 곰팡이 등이 있는 곳에서도 서식합니다.",
        "주기적으로 청소를 하고, 습기를 제거합니다.\n" +
                "음식물 쓰레기를 자주 버리고, 깨끗하게 치웁니다.\n" +
                "곰팡이가 생기지 않도록 합니다.\n" +
                "옷장이나 서랍은 자주 열어 환기를 시킵니다.",
        "집게벌레가 발견된 곳을 청소기로 빨아들입니다.\n" +
                "집게벌레가 싫어하는 향을 사용합니다. 예를 들어, 계피, 바닐라, 박하, 라벤더 등의 향을 사용하면 집게벌레가 멀어집니다.\n" +
                "집게벌레를 잡아 죽입니다.\n" +
                "집게벌레는 사람에게 해를 끼치지는 않지만, 보기 흉하고 불쾌감을 줄 수 있습니다. 따라서 위와 같은 방법으로 예방하고, 피해를 받았을 때는 빠르게 처치하는 것이 좋습니다."
    )
}
