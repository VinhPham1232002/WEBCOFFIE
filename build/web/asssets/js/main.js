//Loader
try {
    onload = () => {
        const load = document.getElementById('load');
        if (load !== null) {
            setTimeout(() => {
                load.style.display = 'none';
            }, 2500);
        }
    }
} catch (Exception) {
}
//Show navbar everytime user scroll in main page
var sections = document.querySelectorAll("section[id]");
function onScrollHeader() {
    var scrollY = window.scrollY;

    sections.forEach(current => {
        var sectionHeight = current.offsetHeight;
        var sectionTop = current.offsetTop - 60;
        var sectionId = current.getAttribute("id");

        if (scrollY > sectionTop && scrollY <= sectionTop + sectionHeight) {
            document.querySelector(".header__navbar-item a[href*=" + sectionId + "]").classList.add("seperate__divider-current-line");
        } else {
            document.querySelector(".header__navbar-item a[href*=" + sectionId + "]").classList.remove("seperate__divider-current-line");
        }
    })
}
window.addEventListener('scroll', onScrollHeader);

//Check if checkbox was check then animation angle down to up
var headerLoggingTable = document.querySelector(".header__logging-data");
var headerLoggingList = document.querySelector(".js-logging-group");
var closeElement = document.querySelector(".header__logging-close");
var overLayElement = document.querySelector(".header__logging-overlay");

//Left and right products type 
var productsGroup = document.querySelectorAll(".products__group");
var arrow = document.querySelectorAll(".products__arrow");
var leftArrow = arrow[0];
var rightArrow = arrow[1]

function clickArrow(foo) {
    var productsItemBlock;
    var visibleProductItemBlock;
    var index = 0;

    for (var i = 0; i < productsGroup.length; i++) {
        if (productsGroup[i].style.display === "block") {
            productsItemBlock = productsGroup[i];
            index = i;
        }
    }

    index = foo(index, productsGroup);

    productsItemBlock.style.display = "none";
    visibleProductItemBlock = productsGroup[index];
    var showVisibleProductItem = visibleProductItemBlock;
    showVisibleProductItem.click();
    visibleProductItemBlock.style.display = "block";
}

try {
    function clickArrowLeft() {
        return clickArrow((index, productsGroup) => {
            if (index - 1 < 0) {
                return productsGroup.length - 1;
            } else {
                return index - 1;
            }
        });
    }
    leftArrow.addEventListener("click", clickArrowLeft);

    function clickArrowRight() {
        return clickArrow((index, productsGroup) => {
            if (index === productsGroup.length - 1) {
                return 0;
            } else {
                return index + 1;
            }
        });
    }

    rightArrow.addEventListener("click", clickArrowRight);
} catch (Exception) {
}
;
//Close table when user click X icon
function closeTable() {
    headerLoggingList.style.transform = 'translateX(-100%)';
    headerLoggingTable.style.boxShadow = 'none';
    overLayElement.style.display = 'none';
    setTimeout(function () {
        headerLoggingTable.style.display = 'none';
    }, 1000);
}
if (closeElement !== null) {
    closeElement.addEventListener('click', closeTable);
}

//Mix it up
try {
    let mixerProducts = mixitup('.products__content', {
        selectors: {
            target: '.products__card'
        },
        animation: {
            duration: 300
        },
        pagination: {
            limit: 4
        }
    });
    mixerProducts.filter('.delicacies');
} catch (Exception) {
}

//Set up new link for buy and favorite when user logging
var productsButton = document.querySelectorAll(".button.products__button");
var headerLogging = document.querySelector(".header__logging");

if (headerLogging !== null) {
    for (var linkProduct of productsButton) {
        linkProduct.removeAttribute("href");
        linkProduct.setAttribute("onclick", "onclickProduct(this)");
    }
}

window.addEventListener("resize", function() {
    var windowSize = window.innerWidth
            || document.documentElement.clientWidth
            || document.body.clientWidth;
    console.log(windowSize);
    if (windowSize > 768) {
        document.querySelector(".side-bar__show-side-bar").style.transform = "unset"
    }
});