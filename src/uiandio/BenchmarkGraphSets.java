package uiandio;

public class BenchmarkGraphSets {
    public static String[] getSetNames() {
        return new String[] {
            "bg512",
            "dao",
            "sc1",
            "wc3maps512",
            "room8",
            "room16",
            "room32",
            "room64",
            "mazes1",
            "mazes2",
            "mazes4",
            "mazes8",
            "mazes16",
            "mazes32",
            "random10",
            "random15",
            "random20",
            "random25",
            "random30",
            "random35",
            "random40",
        };
    }
    
    public static String[] getBenchmarkSet(String setName) {
        switch (setName) {
            case "mazes16": return new String[] {
                "maze512-16-7",
                "maze512-16-5",
                "maze512-16-9",
                "maze512-16-6",
                "maze512-16-2",
                "maze512-16-1",
                "maze512-16-0",
                "maze512-16-4",
                "maze512-16-8",
                "maze512-16-3",
            };
            case "random15": return new String[] {
                "random512-15-4",
                "random512-15-8",
                "random512-15-1",
                "random512-15-5",
                "random512-15-2",
                "random512-15-3",
                "random512-15-6",
                "random512-15-0",
                "random512-15-7",
                "random512-15-9",
            };
            case "sc1": return new String[] {
                "BrokenSteppes",
                "Sandstorm",
                "RedCanyons",
                "Entanglement",
                "WaypointJunction",
                "IceFloes",
                "Sanctuary",
                "Backwoods",
                "SpaceAtoll",
                "CrashSites",
                "GhostTown",
                "ArcticStation",
                "CatwalkAlley",
                "TheFrozenSea",
                "LakeShore",
                "GladiatorPits",
                "ValleyofRe",
                "Caldera",
                "Labyrinth",
                "Predators",
                "Isolation",
                "WinterConquest",
                "Hellfire",
                "TaleofTwoCities",
                "Enigma",
                "OrbitalGully",
                "HotZone",
                "NovaStation",
                "Rosewood",
                "Sirocco",
                "BlackLotus",
                "ShroudPlatform",
                "JungleSiege",
                "CrescentMoon",
                "Tribes",
                "Archipelago",
                "FireWalker",
                "RiverLethe",
                "IceMountain",
                "BigGameHunters",
                "Turbo",
                "TheatreofWar",
                "Legacy",
                "ThinIce",
                "FloodedPlains",
                "Aurora",
                "Brushfire",
                "Aftershock",
                "Eruption",
                "Triskelion",
                "Nightshade",
                "Ramparts",
                "Medusa",
                "WatersEdge",
                "GreenerPastures",
                "DarkContinent",
                "PrimevalIsles",
                "TheHighway",
                "Octopus",
                "SpaceDebris",
                "Cauldron",
                "AcrosstheCape",
                "Elderlands",
                "Inferno",
                "BlastFurnace",
                "SteppingStones",
                "EbonLakes",
                "Crossroads",
                "SpringThaw",
                "Expedition",
                "SapphireIsles",
                "Desolation",
                "WheelofWar",
                "WarpGates",
                "Typhoon",
            };
            case "bg512": return new String[] {
                "AR0404SR",
                "AR0041SR",
                "AR0709SR",
                "AR0505SR",
                "AR0012SR",
                "AR0602SR",
                "AR0413SR",
                "AR0044SR",
                "AR0405SR",
                "AR0503SR",
                "AR0406SR",
                "AR0201SR",
                "AR0410SR",
                "AR0412SR",
                "AR0604SR",
                "AR0202SR",
                "AR0301SR",
                "AR0601SR",
                "AR0203SR",
                "AR0304SR",
                "AR0513SR",
                "AR0011SR",
                "AR0316SR",
                "AR0704SR",
                "AR0603SR",
                "AR0509SR",
                "AR0045SR",
                "AR0018SR",
                "AR0317SR",
                "AR0014SR",
                "AR0711SR",
                "AR0418SR",
                "AR0072SR",
                "AR0700SR",
                "AR0046SR",
                "AR0500SR",
                "AR0017SR",
                "AR0506SR",
                "AR0306SR",
                "AR0502SR",
                "AR0314SR",
                "AR0020SR",
                "AR0510SR",
                "AR0414SR",
                "AR0504SR",
                "AR0204SR",
                "AR0411SR",
                "AR0517SR",
                "AR0701SR",
                "AR0042SR",
                "AR0400SR",
                "AR0206SR",
                "AR0331SR",
                "AR0516SR",
                "AR0600SR",
                "AR0605SR",
                "AR0305SR",
                "AR0511SR",
                "AR0205SR",
                "AR0013SR",
                "AR0702SR",
                "AR0309SR",
                "AR0526SR",
                "AR0043SR",
                "AR0016SR",
                "AR0300SR",
                "AR0705SR",
                "AR0015SR",
                "AR0307SR",
                "AR0071SR",
                "AR0310SR",
                "AR0070SR",
                "AR0303SR",
                "AR0302SR",
                "AR0308SR",
            };
            case "mazes4": return new String[] {
                "maze512-4-9",
                "maze512-4-0",
                "maze512-4-1",
                "maze512-4-2",
                "maze512-4-8",
                "maze512-4-7",
                "maze512-4-3",
                "maze512-4-5",
                "maze512-4-6",
                "maze512-4-4",
            };
            case "mazes8": return new String[] {
                "maze512-8-3",
                "maze512-8-1",
                "maze512-8-9",
                "maze512-8-6",
                "maze512-8-7",
                "maze512-8-8",
                "maze512-8-5",
                "maze512-8-4",
                "maze512-8-2",
                "maze512-8-0",
            };
            case "room8": return new String[] {
                "8room_005",
                "8room_007",
                "8room_003",
                "8room_001",
                "8room_009",
                "8room_008",
                "8room_000",
                "8room_004",
                "8room_006",
                "8room_002",
            };
            case "room32": return new String[] {
                "32room_004",
                "32room_007",
                "32room_008",
                "32room_009",
                "32room_005",
                "32room_003",
                "32room_001",
                "32room_000",
                "32room_006",
                "32room_002",
            };
            case "mazes2": return new String[] {
                "maze512-2-2",
                "maze512-2-4",
                "maze512-2-3",
                "maze512-2-1",
                "maze512-2-0",
                "maze512-2-7",
                "maze512-2-9",
                "maze512-2-6",
                "maze512-2-5",
                "maze512-2-8",
            };
            case "mazes1": return new String[] {
                "maze512-1-9",
                "maze512-1-6",
                "maze512-1-0",
                "maze512-1-4",
                "maze512-1-3",
                "maze512-1-7",
                "maze512-1-5",
                "maze512-1-1",
                "maze512-1-2",
                "maze512-1-8",
            };
            case "room64": return new String[] {
                "64room_003",
                "64room_001",
                "64room_004",
                "64room_006",
                "64room_007",
                "64room_000",
                "64room_002",
                "64room_005",
                "64room_008",
                "64room_009",
            };
            case "random40": return new String[] {
                "random512-40-5",
                "random512-40-7",
                "random512-40-2",
                "random512-40-0",
                "random512-40-3",
                "random512-40-8",
                "random512-40-1",
                "random512-40-9",
                "random512-40-6",
                "random512-40-4",
            };
            case "dao": return new String[] {
                "lak100c",
                "orz100d",
                "orz901d",
                "lak511d",
                "den001d",
                "orz701d",
                "den204d",
                "lak503d",
                "den401d",
                "den020d",
                "orz000d",
                "lak100d",
                "oth999d",
                "hrt002d",
                "brc100d",
                "den520d",
                "den601d",
                "lak403d",
                "den200d",
                "lak514d",
                "orz106d",
                "lak101d",
                "brc504d",
                "lak202d",
                "den500d",
                "lak109d",
                "orz101d",
                "lak203d",
                "brc999d",
                "lak103d",
                "hrt001d",
                "orz302d",
                "lak100n",
                "brc202d",
                "hrt201n",
                "lak107d",
                "lak401d",
                "brc501d",
                "den505d",
                "lak108d",
                "orz107d",
                "lgt602d",
                "brc203d",
                "lak505d",
                "lak507d",
                "orz301d",
                "ost000t",
                "lak405d",
                "lak512d",
                "lak308d",
                "ost004d",
                "lak304d",
                "brc200d",
                "den201d",
                "orz103d",
                "ost003d",
                "lak300d",
                "hrt201d",
                "lak506d",
                "orz105d",
                "den206d",
                "den101d",
                "brc502d",
                "ost000a",
                "combat2",
                "orz703d",
                "lak200d",
                "den400d",
                "ost001d",
                "ost100d",
                "arena2",
                "brc201d",
                "den403d",
                "lak106d",
                "orz700d",
                "lak105d",
                "lgt601d",
                "den011d",
                "lgt605d",
                "den203d",
                "lak307d",
                "den602d",
                "den900d",
                "lak504d",
                "ost002d",
                "brc000d",
                "orz300d",
                "lak104d",
                "brc101d",
                "isound1",
                "orz203d",
                "den408d",
                "lak303d",
                "orz304d",
                "den998d",
                "lak519d",
                "combat",
                "orz500d",
                "orz303d",
                "ost102d",
                "den901d",
                "oth001d",
                "brc300d",
                "den510d",
                "den600d",
                "lak404d",
                "den207d",
                "lak250d",
                "lak102d",
                "lak513d",
                "brc505d",
                "den404d",
                "rmtst01",
                "den312d",
                "den000d",
                "lak515d",
                "den502d",
                "lgt604d",
                "den202d",
                "oth000d",
                "lak302d",
                "den005d",
                "lak510d",
                "orz702d",
                "orz201d",
                "den501d",
                "brc503d",
                "den200n",
                "den308d",
                "lak400d",
                "rmtst",
                "den407d",
                "lgt101d",
                "lgt300d",
                "ost101d",
                "arena",
                "orz704d",
                "brc204d",
                "lak110d",
                "lak526d",
                "orz102d",
                "orz900d",
                "lgt600d",
                "lak201d",
                "den405d",
                "den009d",
                "orz800d",
                "den012d",
                "brc997d",
                "hrt000d",
                "orz200d",
                "orz999d",
                "lgt603d",
                "rmtst03",
                "orz601d",
                "den504d",
            };
            case "wc3maps512": return new String[] {
                "plunderisle",
                "theglaive",
                "hillsofglory",
                "scen",
                "plaguelands",
                "harrow",
                "thecrucible",
                "frostsabre",
                "battleground",
                "ogremound",
                "gardenofwar",
                "heart2heart",
                "losttemple",
                "bootybay",
                "forestwalk",
                "stromguarde",
                "icecrown",
                "golemsinthemist",
                "deadwaterdrop",
                "darkforest",
                "gnollwood",
                "map",
                "blastedlands",
                "scorchedbasin",
                "swampofsorrows",
                "duskwood",
                "riverrun",
                "harvestmoon",
                "tranquilpaths",
                "petrifiedforest",
                "nighthaven",
                "isleofdread",
                "divideandconquer",
                "dragonmountain",
                "dragonfire",
                "bloodvenomfalls",
                "drywatergulch",
                "timbermawhold",
                "moonglade",
                "legends",
                "dustwallowkeys",
                "plainsofsnow",
                "mysticisles",
            };
            case "room16": return new String[] {
                "16room_000",
                "16room_004",
                "16room_007",
                "16room_005",
                "16room_009",
                "16room_002",
                "16room_001",
                "16room_008",
                "16room_003",
                "16room_006",
            };
            case "mazes32": return new String[] {
                "maze512-32-7",
                "maze512-32-2",
                "maze512-32-6",
                "maze512-32-9",
                "maze512-32-3",
                "maze512-32-5",
                "maze512-32-8",
                "maze512-32-1",
                "maze512-32-0",
                "maze512-32-4",
            };
            case "random25": return new String[] {
                "random512-25-6",
                "random512-25-8",
                "random512-25-9",
                "random512-25-5",
                "random512-25-3",
                "random512-25-7",
                "random512-25-4",
                "random512-25-1",
                "random512-25-0",
                "random512-25-2",
            };
            case "random20": return new String[] {
                "random512-20-0",
                "random512-20-7",
                "random512-20-6",
                "random512-20-5",
                "random512-20-8",
                "random512-20-1",
                "random512-20-3",
                "random512-20-9",
                "random512-20-4",
                "random512-20-2",
            };
            case "random30": return new String[] {
                "random512-30-2",
                "random512-30-9",
                "random512-30-5",
                "random512-30-6",
                "random512-30-8",
                "random512-30-7",
                "random512-30-3",
                "random512-30-1",
                "random512-30-0",
                "random512-30-4",
            };
            case "random35": return new String[] {
                "random512-35-7",
                "random512-35-2",
                "random512-35-0",
                "random512-35-9",
                "random512-35-8",
                "random512-35-5",
                "random512-35-4",
                "random512-35-3",
                "random512-35-1",
                "random512-35-6",
            };
            case "random10": return new String[] {
                "random512-10-6",
                "random512-10-5",
                "random512-10-7",
                "random512-10-9",
                "random512-10-1",
                "random512-10-8",
                "random512-10-2",
                "random512-10-3",
                "random512-10-4",
                "random512-10-0",
            };
        };
        return null;
    }
}