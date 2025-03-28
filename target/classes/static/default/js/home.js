    const contentList = [
    {
        subtitle: "Join Hands to Protect Environment",
        text: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    },
    {
        subtitle: "Protect Wildlife and Nature",
        text: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec vel lacus ac risus."
    },
    {
        subtitle: "Act Now for a Green Future",
        text: "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi dut aliquip ex ea commodo consequat."
    }
    ];

    let currentIndex = 0; // Chỉ mục hiện tại
    document.addEventListener("DOMContentLoaded", function() {
        const buttonUp = document.querySelector(".button-up");
        const buttonDown = document.querySelector(".button-down");

        if (!buttonUp || !buttonDown) {
            console.error("Không tìm thấy nút lên hoặc xuống.");
            return;
        }

        buttonUp.addEventListener("click", function() {
            currentIndex = (currentIndex > 0) ? currentIndex - 1 : contentList.length - 1;
            updateContent(currentIndex);
        });

        buttonDown.addEventListener("click", function() {
            currentIndex = (currentIndex < contentList.length - 1) ? currentIndex + 1 : 0;
            updateContent(currentIndex);
        });
    });
    function updateContent(index) {
        const subTitleEl = document.getElementById("sub-title");
        const textEl = document.getElementById("main-text");

        if ( !subTitleEl || !textEl) {
            console.error("Không tìm thấy phần tử nội dung.");
            return;
        }

        subTitleEl.innerHTML = contentList[index].subtitle;
        textEl.innerHTML = contentList[index].text;
    }
