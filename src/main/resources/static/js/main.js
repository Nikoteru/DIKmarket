(function () {
  ("use strict");

  var mobileMenuOutsideClick = function () {
    $(document).click(function (e) {
      var container = $("#gtco-offcanvas, .js-gtco-nav-toggle");
      if (!container.is(e.target) && container.has(e.target).length === 0) {
        $(".js-gtco-nav-toggle").addClass("");

        if ($("body").hasClass("offcanvas")) {
          $("body").removeClass("offcanvas");
          $(".js-gtco-nav-toggle").removeClass("active");
        }
      }
    });
  };

  var offcanvasMenu = function () {
    $("#page").prepend('<div id="gtco-offcanvas" />');
    $("#page").prepend(
      '<a href="#" class="js-gtco-nav-toggle gtco-nav-toggle "><i></i></a>'
    );
    var clone1 = $(".menu-1 > ul").clone();
    $("#gtco-offcanvas").append(clone1);
    var clone2 = $(".menu-2 > ul").clone();
    $("#gtco-offcanvas").append(clone2);

    $("#gtco-offcanvas .has-dropdown").addClass("offcanvas-has-dropdown");
    $("#gtco-offcanvas").find("li").removeClass("has-dropdown");

    // Hover dropdown menu on mobile
    $(".offcanvas-has-dropdown")
      .mouseenter(function () {
        var $this = $(this);

        $this.addClass("active").find("ul").slideDown(500, "easeOutExpo");
      })
      .mouseleave(function () {
        var $this = $(this);
        $this.removeClass("active").find("ul").slideUp(500, "easeOutExpo");
      });

    $(window).resize(function () {
      if ($("body").hasClass("offcanvas")) {
        $("body").removeClass("offcanvas");
        $(".js-gtco-nav-toggle").removeClass("active");
      }
    });
  };

  var burgerMenu = function () {
    $("body").on("click", ".js-gtco-nav-toggle", function (event) {
      var $this = $(this);

      if ($("body").hasClass("overflow offcanvas")) {
        $("body").removeClass("overflow offcanvas");
      } else {
        $("body").addClass("overflow offcanvas");
      }
      $this.toggleClass("active");
      event.preventDefault();
    });
  };

  var contentWayPoint = function () {
    var i = 0;

    $(".animate-box").waypoint(
      function (direction) {
        if (
          direction === "down" &&
          !$(this.element).hasClass("animated-fast")
        ) {
          i++;

          $(this.element).addClass("item-animate");
          setTimeout(function () {
            $("body .animate-box.item-animate").each(function (k) {
              var el = $(this);
              setTimeout(
                function () {
                  var effect = el.data("animate-effect");
                  if (effect === "fadeIn") {
                    el.addClass("fadeIn animated-fast");
                  } else if (effect === "fadeInLeft") {
                    el.addClass("fadeInLeft animated-fast");
                  } else if (effect === "fadeInRight") {
                    el.addClass("fadeInRight animated-fast");
                  } else {
                    el.addClass("fadeInUp animated-fast");
                  }

                  el.removeClass("item-animate");
                },
                k * 50,
                "easeInOutExpo"
              );
            });
          }, 100);
        }
      },
      { offset: "85%" }
    );
    // }, { offset: '90%'} );
  };

  var changeWayPoint = function () {
    var i = 0;

    $(".animate-change").waypoint(
      function (direction) {
        if (
          direction === "down" &&
          !$(this.element).hasClass("animated-fast")
        ) {
          i++;

          $(this.element).addClass("item-animate");
          setTimeout(function () {
            $("body .animate-change.item-animate").each(function (k) {
              var el = $(this);
              setTimeout(
                function () {
                  el.addClass("changed animated-fast");
                  el.removeClass("item-animate");
                },
                k * 100,
                "easeInOutExpo"
              );
            });
          }, 100);
        }
      },
      { offset: "85%" }
    );
  };

  var dropdown = function () {
    $(".has-dropdown")
      .mouseenter(function () {
        var $this = $(this);
        $this
          .find(".dropdown")
          .css("display", "block")
          .addClass("animated-fast fadeInUpMenu");
      })
      .mouseleave(function () {
        var $this = $(this);

        $this
          .find(".dropdown")
          .css("display", "none")
          .removeClass("animated-fast fadeInUpMenu");
      });
  };
  // Карусель нижнего блока пролистывания, основной контейнер
  var owlCarousel = function () {
    var owl = $(".owl-carousel-carousel");
    owl.owlCarousel({
      items: 3,
      loop: true,
      margin: 40,
      nav: true,
      dots: false,
      navText: [
        "<img src='/img/LEFT.png'>",
        "<img src='/img/RIGHT.png'>",
      ],
      responsive: {
        0: {
          items: 1,
        },
        600: {
          items: 2,
        },
        1000: {
          items: 3,
        },
      },
    });

    //Блока карусели ВЕРХНЕГО пролистывания
    var owl2 = $(".owl-carousel-fullwidth");
    owl2.owlCarousel({
      items: 1,
      loop: true,
      margin: 20,
      nav: true,
      dots: true,
      autoplay: true,
      autoplayTimeout: 60000,
      autoplayHoverPause: false,
      navText: [
        "<img src='/img/arrow-left-next.png'>",
        "<img src='/img/arrow-right.png'>",
      ],
    });
    //Блока карусели НИЖНЕГО пролистывания
    var owl2 = $(".owl-carousel-fullwidth_1");
    owl2.owlCarousel({
      items: 1,
      loop: true,
      margin: 20,
      dots: true,
      autoplayHoverPause: false,
    });
  };
  var tabs = function () {
    // Auto adjust height
    $(".gtco-tab-content-wrap").css("height", 0);
    var autoHeight = function () {
      setTimeout(function () {
        var tabContentWrap = $(".gtco-tab-content-wrap"),
          tabHeight = $(".gtco-tab-nav").outerHeight(),
          formActiveHeight = $(".tab-content.active").outerHeight(),
          totalHeight = parseInt(tabHeight + formActiveHeight + 90);

        tabContentWrap.css("height", totalHeight);

        $(window).resize(function () {
          var tabContentWrap = $(".gtco-tab-content-wrap"),
            tabHeight = $(".gtco-tab-nav").outerHeight(),
            formActiveHeight = $(".tab-content.active").outerHeight(),
            totalHeight = parseInt(tabHeight + formActiveHeight + 90);

          tabContentWrap.css("height", totalHeight);
        });
      }, 100);
    };

    autoHeight();

    // Click tab menu
    $(".gtco-tab-nav a").on("click", function (event) {
      var $this = $(this),
        tab = $this.data("tab");

      $(".tab-content").addClass("animated-fast fadeOutDown");

      $(".tab-content").removeClass("active");

      $(".gtco-tab-nav li").removeClass("active");

      $this.closest("li").addClass("active");

      $this
        .closest(".gtco-tabs")
        .find('.tab-content[data-tab-content="' + tab + '"]')
        .removeClass("animated-fast fadeOutDown")
        .addClass("animated-fast active fadeIn");

      autoHeight();
      event.preventDefault();
    });
  };

  var goToTop = function () {
    $(".js-gotop").on("click", function (event) {
      event.preventDefault();

      $("html, body").animate(
        {
          scrollTop: $("html").offset().top,
        },
        500,
        "easeInOutExpo"
      );

      return false;
    });

    $(window).scroll(function () {
      var $win = $(window);
      if ($win.scrollTop() > 200) {
        $(".js-top").addClass("active");
      } else {
        $(".js-top").removeClass("active");
      }
    });
  };

  // Loading page
  var loaderPage = function () {
    $(".gtco-loader").fadeOut("slow");
  };

  var counter = function () {
    $(".js-counter").countTo({
      formatter: function (value, options) {
        return value.toFixed(options.decimals);
      },
    });
  };

  var counterWayPoint = function () {
    if ($("#gtco-counter").length > 0) {
      $("#gtco-counter").waypoint(
        function (direction) {
          if (direction === "down" && !$(this.element).hasClass("animated")) {
            setTimeout(counter, 400);
            $(this.element).addClass("animated");
          }
        },
        { offset: "90%" }
      );
    }
  };

  $(function () {
    owlCarousel();
    mobileMenuOutsideClick();
    offcanvasMenu();
    burgerMenu();
    contentWayPoint();
    dropdown();

    tabs();
    goToTop();
    loaderPage();
    counterWayPoint();
    changeWayPoint();
  });
})();













// Click js-menu-toggle(при нажатии открывается бар
(function(){

  'use strict'


  var siteMenuClone = function() {
    var jsCloneNavs = document.querySelectorAll('.js-clone-nav');
    var siteMobileMenuBody = document.querySelector('.site-mobile-menu-body');



    jsCloneNavs.forEach(nav => {
      var navCloned = nav.cloneNode(true);
      navCloned.setAttribute('class', 'site-nav-wrap');
      siteMobileMenuBody.appendChild(navCloned);
    });

    setTimeout(function(){

      var hasChildrens = document.querySelector('.site-mobile-menu').querySelectorAll(' .has-children');

      var counter = 0;
      hasChildrens.forEach( hasChild => {

        var refEl = hasChild.querySelector('a');

        var newElSpan = document.createElement('span');
        newElSpan.setAttribute('class', 'arrow-collapse collapsed');

        // prepend equivalent to jquery
        hasChild.insertBefore(newElSpan, refEl);

        var arrowCollapse = hasChild.querySelector('.arrow-collapse');
        arrowCollapse.setAttribute('data-bs-toggle', 'collapse');
        arrowCollapse.setAttribute('data-bs-target', '#collapseItem' + counter);

        var dropdown = hasChild.querySelector('.dropdown');
        dropdown.setAttribute('class', 'collapse');
        dropdown.setAttribute('id', 'collapseItem' + counter);

        counter++;
      });

    }, 1000);


    // Click js-menu-toggle(при нажатии открывается бар

    var menuToggle = document.querySelectorAll(".js-menu-toggle");
    var mTog;
    menuToggle.forEach(mtoggle => {
      mTog = mtoggle;
      mtoggle.addEventListener("click", (e) => {
        if ( document.body.classList.contains('offcanvas-menu') ) {
          document.body.classList.remove('offcanvas-menu');
          mtoggle.classList.remove('active');
          mTog.classList.remove('active');
        } else {
          document.body.classList.add('offcanvas-menu');
          mtoggle.classList.add('active');
          mTog.classList.add('active');
        }
      });
    })



    var specifiedElement = document.querySelector(".site-mobile-menu");
    var mt, mtoggleTemp;
    document.addEventListener('click', function(event) {
      var isClickInside = specifiedElement.contains(event.target);
      menuToggle.forEach(mtoggle => {
        mtoggleTemp = mtoggle
        mt = mtoggle.contains(event.target);
      })

      if (!isClickInside && !mt) {
        if ( document.body.classList.contains('offcanvas-menu') ) {
          document.body.classList.remove('offcanvas-menu');
          mtoggleTemp.classList.remove('active');
        }
      }

    });

  };
  siteMenuClone();


})()