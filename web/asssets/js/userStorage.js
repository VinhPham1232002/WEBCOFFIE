//Waiting process - AJAX
var waitingProcess = `    <div class="load load-verify" id="load" style="display: grid; background-color: rgba(67, 62, 62, 0.68);">
        <div style="display: flex;align-items: center;column-gap: 1rem;margin-top: auto;margin-right: auto;padding: 12px;">
            <img src="asssets/img/coffie__loading.gif" alt="" class="load-gif" style="width: 60px;height: 60px;">    
            <div style="display:flex; align-items:center; column-gap:2rem;">
                <span class="load-text;" style="font-family: 'Gloria Hallelujah', cursive;color: white;">NOW LOADING</span>
                  <div class="stage">
                    <div class="dot-flashing"></div>
                  </div>
            </div>
        </div>
    </div>`;

var waitngProcess1 =`<div class="side-bar__appearance-body on-loading-process">
<div class="side-bar__appearance-group">
    <div class="side-bar__appearance-message-box">
        <img src="asssets/img/no-orders.gif" alt="" class="side-bar__appearance-gif">
        <div class="side-bar__appearance-message">
            <p>"Running Now~~"
            </p>
        </div>
    </div>
</div>
</div>`;

var waitingProcess3 = `    <div class="load load-verify" id="load" style="display: grid; background-color: rgba(67, 62, 62, 0.68);">
        <div style="display: flex;align-items: center;column-gap: 1rem;margin-top: auto;margin-right: auto;padding: 12px;">
            <img src="asssets/img/cat.gif" alt="" class="load-gif" style="width: 60px;height: 60px;">    
            <div style="display:flex; align-items:center; column-gap:2rem;">
                <span class="load-text;" style="font-family: 'Gloria Hallelujah', cursive;color: white;">NOW LOADING</span>
                  <div class="stage">
                    <div class="dot-flashing"></div>
                  </div>
            </div>
        </div>
    </div>`;

var contentLoading = `    <div class="load load-verify" id="load" style="display: grid; background-color: rgba(67, 62, 62, 0.68);">
        <div style="display: flex;align-items: center;column-gap: 1rem;margin-top: auto;margin-right: auto;padding: 12px;">
            <img src="asssets/img/PeCq.gif" alt="" class="load-gif" style="width: 60px;height: 60px;">    
            <div style="display:flex; align-items:center; column-gap:2rem;">
                <span class="load-text;" style="font-family: 'Gloria Hallelujah', cursive;color: white;">NOW LOADING</span>
                  <div class="stage">
                    <div class="dot-flashing"></div>
                  </div>
            </div>
        </div>
    </div>`;
var contentLoading2 = `    <div class="load load-verify" id="load" style="display: grid; background-color: rgba(67, 62, 62, 0.68);">
        <div style="display: flex;align-items: center;column-gap: 1rem;margin-top: auto;margin-right: auto;padding: 12px;">
            <img src="asssets/img/waiting-3.gif" alt="" class="load-gif" style="width: 60px;height: 60px;">    
            <div style="display:flex; align-items:center; column-gap:2rem;">
                <span class="load-text;" style="font-family: 'Gloria Hallelujah', cursive;color: white;">NOW LOADING</span>
                  <div class="stage">
                    <div class="dot-flashing"></div>
                  </div>
            </div>
        </div>
    </div>`;
//Close open
var deleteAccount = `<div class="table__change table__delete" style="display:none">
<div class="table__changing-overlay" onclick="closeTableChange()" style="opacity:1">
    <div class="table__changing-box" onclick="event.stopPropagation();">
        <div class="table__changing-title">
            <h1 class="table__changing-heading">Delete Account</h1>
            <span class="table__changing-text table__warning-set">Are you sure that you want to delete your account? This will immediately log you out of your account and you will not be able to log in again.</span>
            <button type="button" class="table__changing-close" onclick="closeTableChange()">
                <div class="table__changing-close-icon">
                    <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                        viewBox="0 0 24 24">
                        <path fill="currentColor"
                            d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                        </path>
                    </svg>
                </div>
                <div class="side-bar__overview flex-item-col-center" onclick="closeTableChange()">
                <i class="ti-angle-left"></i>
                <span class="side-bar__overview-text">Overview</span>
            </div>
            </button>
        </div>
            <div class="table__changing-button">
                <div class="table__changing-input-box">
                    <div>
                        <h5 class="table__changing-input-text">Password</h5>
                        <input type="password" class="table__changing-input" name="newNickName" spellcheck="false">
                    </div>
                </div>
            </div>
            <div class="table__box-button">
                <button type="button" class="table__changing-btn table__full-changing"
                    onclick="closeTableChange()"><span>Cancel<span></button>
                <button type="button" class="table__changing-btn table__full-changing js-delete" onclick="deleteUser(this)">Done</button>
            </div>
        </div>
    </div>
</div>`;
var changePassWord = `<div class="table__change" style="display:none">
<div class="table__changing-overlay" style="opacity:1;" onclick="closeTableChange()">
    <div class="table__changing-box" onclick="event.stopPropagation();">
        <div class="table__changing-title">
            <h1 class="table__changing-heading">Update your password</h1>
            <span class="table__changing-text">Enter your current password and a new password.</span>
            <button type="button" class="table__changing-close" onclick="closeTableChange()">
                <div class="table__changing-close-icon">
                    <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                        viewBox="0 0 24 24">
                        <path fill="currentColor"
                            d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                        </path>
                    </svg>
                </div>
                <div class="side-bar__overview flex-item-col-center" onclick="closeTableChange()">
                    <i class="ti-angle-left"></i>
                    <span class="side-bar__overview-text">Overview</span>
                </div>
            </button>
        </div>
            <div class="table__changing-button">
                <div class="table__changing-input-box">
                    <h5 class="table__changing-input-text table__changing-current-text">Current password</h5>
                    <div>
                        <input type="password" class="table__changing-input theme-light-black border-deprecated" name="currentPassword" spellcheck="false">
                    </div>
                </div>
                <div class="table__changing-input-box field-Spacer-Top-20">
                    <h5 class="table__changing-input-text table__changing-new-text">New password</h5>
                    <div>
                        <input type="password" class="table__changing-input theme-light-black border-deprecated" name="newPassword" spellcheck="false">
                    </div>
                </div>
                <div class="table__changing-input-box field-Spacer-Top-20">
                    <h5 class="table__changing-input-text table__changing-confirm-text">Confirm new password</h5>
                    <div>
                        <input type="password" class="table__changing-input theme-light-black border-deprecated" name="confirmPassword" spellcheck="false">
                    </div>
                </div>
            </div>
            <div class="table__changing-box-button">
                <button type="button" class="table__changing-btn table__full-changing" onclick="closeTableChange()"><span>Cancel<span></button>
                <button type="button" class="table__changing-btn table__full-changing" onclick="form_password_change()">Done</button>
            </div>
    </div>
</div>
</div>`;

var changeImage = `<div class="table__change table__change-img" style="display:none">
        <div class="table__changing-overlay" value="js-non-mobile" style="opacity:1;transform:translateX(0%)" onclick="closeTableChange()">
            <div class="table__changing-box" onclick="event.stopPropagation();">
                <div class="table__changing-title" style="padding:16px;">
                    <h1 class="table__changing-heading table__changing-image-title">Select Image</h1>
                    <button type="button" class="table__changing-close" style="top:18px;" onclick="closeTableChange()">
                        <div class="table__changing-close-icon">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                                viewBox="0 0 24 24">
                                <path fill="currentColor"
                                    d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                                </path>
                            </svg>
                        </div>
                    </button>
                </div>
                <div class="table__changing-image-control">
                    <div class="table__changing-image field-Spacer-right-16">
                        <div class="table__changing-image-circle">
                            <svg class="svg-modifier svg-middle" aria-hidden="false" width="24" height="24"
                                viewBox="0 0 24 24" fill="none">
                                <path fill-rule="evenodd" clip-rule="evenodd"
                                    d="M13.2899 2L6 2C3.79086 2 2 3.79086 2 6V18C2 20.2091 3.79086 22 6 22H18C20.2091 22 22 20.2091 22 18V10.7101C21.3663 10.8987 20.695 11 20 11C16.134 11 13 7.86599 13 4C13 3.30503 13.1013 2.63371 13.2899 2ZM8 6C9.1032 6 10 6.8952 10 8C10 9.1056 9.1032 10 8 10C6.8944 10 6 9.1056 6 8C6 6.8952 6.8944 6 8 6ZM6 18L9 14L11 16L15 11L18 18H6Z"
                                    fill="currentColor"></path>
                                <path d="M21 0V3H24V5H21V8H19V5H16V3H19V0H21Z" fill="currentColor"></path>
                            </svg>
                        </div>
                        <div class="table__changing-image-box">
                            <div class="table__changing-image-option-text">
                                <div class="table__changing-image-option-description">Update Image</div>
                            </div>
                        </div>
                        <input class="file-input Primary-font" type="file" tabindex="-1" multiple="false"
                            accept=".jpg,.jpeg,.png,.gif" onchange="getImageFile(this)"
                            style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; opacity: 0; cursor: pointer; font-size: 0px;-webkit-tap-highlight-color: transparent;">
                    </div>
                    <div class="table__changing-image">
                        <div class="table__changing-current-image" style="background-image: url('asssets/img/avatar.webp');">
                            
                        </div>
                        <div class="table__changing-image-box">
                            <div class="table__changing-image-option-text">
                                <div class="table__changing-image-option-description">Your Image</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="table__box-button">
                    <button type="button" class="table__changing-btn table__full-changing" style="display: none;" onclick="closeTableChange()"><span>Cancel<span></button>
                    <button type="submit" disabled="disabled" class="table__changing-btn table__changing-submit js-button-image table__full-changing" onclick="changeUser(this)">Save</button>
                </div>
            </div>
        </div>`;

var changeImageError = `            <div class="table__msg-file table__change" style="display:none">
                <div class="table__changing-overlay" value="js-non-mobile" style="opacity:1; transform:translateX(0%)" onclick="closeTableChange()">
                    <div class="table__changing-box" onclick="event.stopPropagation();">
                        <div class="table__changing-title">
                            <img src="asssets/img/opps.gif" alt="" class="table__forget-img">
                            <h1 class="table__changing-heading" style="margin-top:-3rem;">Your files are two powerful</h1>
                            <span class="table__changing-sub-heading">The max file size is 8MB</span>
                            <button type="button" class="table__changing-close" onclick="closeTableChange()">
                                <div class="table__changing-close-icon">
                                    <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                                        viewBox="0 0 24 24">
                                        <path fill="currentColor"
                                            d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                                        </path>
                                    </svg>
                                </div>
                            </button>
                        </div>
                        <form novalidate="" method="post">
                            <div class="table__changing-box-button">
                                <button type="button" class="table__changing-btn table__full-changing" onclick="closeTableChange()"><span>Cancel</span></button>
                                <input type="submit" class="table__changing-btn table__full-changing" style="display:none;" value="Send">
                            </div>
                        </form>
                    </div>
                </div>
            </div>`;

var changeTablePhone = `<div class="table__change table__change-phone" style="display:none">
<div class="table__changing-overlay" style="opacity:1" onclick="closeTableChange()">
    <div class="table__changing-box" onclick="event.stopPropagation();">
        <div class="table__changing-title">
            <div class="table__phone-verify">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 220 236" width="24" height="24"
                    preserveAspectRatio="xMidYMid meet"
                    style="width: 20rem; height: 20rem; transform: translate3d(0px, 0px, 0px);">
                    <defs>
                        <clipPath id="__lottie_element_2">
                            <rect width="220" height="236" x="0" y="0"></rect>
                        </clipPath>
                        <clipPath id="__lottie_element_25">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <filter id="__lottie_element_27" filterUnits="objectBoundingBox" x="0%" y="0%"
                            width="100%" height="100%">
                            <feColorMatrix type="matrix" color-interpolation-filters="linearRGB"
                                values="0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0 0 0 1 0"
                                result="f1"></feColorMatrix>
                            <feColorMatrix type="matrix" color-interpolation-filters="sRGB"
                                values="1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1 0" result="f2"></feColorMatrix>
                        </filter>
                        <clipPath id="__lottie_element_29">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <clipPath id="__lottie_element_36">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <clipPath id="__lottie_element_43">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <clipPath id="__lottie_element_50">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <clipPath id="__lottie_element_57">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <filter id="__lottie_element_59" filterUnits="objectBoundingBox" x="0%" y="0%"
                            width="100%" height="100%">
                            <feColorMatrix type="matrix" color-interpolation-filters="linearRGB"
                                values="0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0 0 0 1 0"
                                result="f1"></feColorMatrix>
                            <feColorMatrix type="matrix" color-interpolation-filters="sRGB"
                                values="1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1 0" result="f2"></feColorMatrix>
                        </filter>
                        <clipPath id="__lottie_element_61">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <clipPath id="__lottie_element_68">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <clipPath id="__lottie_element_75">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                        <clipPath id="__lottie_element_82">
                            <path d="M0,0 L35,0 L35,35 L0,35z"></path>
                        </clipPath>
                    </defs>
                    <g clip-path="url(#__lottie_element_2)">
                        <g transform="matrix(1,0,0,1,35.84600067138672,134.1490020751953)" opacity="0.25"
                            style="display: block;">
                            <g opacity="1" transform="matrix(1,0,0,1,81.7959976196289,47.928001403808594)">
                                <path fill="rgb(31,33,36)" fill-opacity="1"
                                    d=" M79.9280014038086,-15.520000457763672 C79.9280014038086,-15.520000457763672 26.187000274658203,-46.54800033569336 26.187000274658203,-46.54800033569336 C24.224000930786133,-47.67900085449219 20.94700050354004,-47.560001373291016 18.722999572753906,-46.27899932861328 C18.722999572753906,-46.27899932861328 -79.46399688720703,10.409000396728516 -79.46399688720703,10.409000396728516 C-80.78700256347656,11.17300033569336 -81.5459976196289,12.256999969482422 -81.5459976196289,13.385000228881836 C-81.5459976196289,14.38599967956543 -80.97200012207031,15.270000457763672 -79.9280014038086,15.87399959564209 C-79.9280014038086,15.87399959564209 -26.187000274658203,46.900001525878906 -26.187000274658203,46.900001525878906 C-25.283000946044922,47.42100143432617 -24.10300064086914,47.678001403808594 -22.871999740600586,47.678001403808594 C-21.430999755859375,47.678001403808594 -19.92300033569336,47.32500076293945 -18.722999572753906,46.63199996948242 C-18.722999572753906,46.63199996948242 79.46399688720703,-10.055000305175781 79.46399688720703,-10.055000305175781 C80.78700256347656,-10.819999694824219 81.5459976196289,-11.906000137329102 81.5459976196289,-13.034000396728516 C81.54499816894531,-14.03499984741211 80.97200012207031,-14.916999816894531 79.9280014038086,-15.520000457763672z">
                                </path>
                            </g>
                        </g>
                        <g transform="matrix(1,0,0,1,25.810997009277344,118.64900207519531)" opacity="1"
                            style="display: block;">
                            <g opacity="1" transform="matrix(1,0,0,1,81.85800170898438,52.93299865722656)">
                                <path fill="rgb(31,33,36)" fill-opacity="1"
                                    d=" M81.54499816894531,-18.048999786376953 C81.54499816894531,-18.048999786376953 81.54499816894531,-18.101999282836914 81.54499816894531,-18.101999282836914 C81.54499816894531,-18.152000427246094 81.52400207519531,-18.19499969482422 81.51699829101562,-18.242000579833984 C81.44100189208984,-19.1560001373291 80.89900207519531,-19.96299934387207 79.92900085449219,-20.523000717163086 C79.92900085449219,-20.523000717163086 26.187999725341797,-51.54899978637695 26.187999725341797,-51.54899978637695 C24.225000381469727,-52.68299865722656 20.94499969482422,-52.566001892089844 18.724000930786133,-51.28300094604492 C18.724000930786133,-51.28300094604492 -79.46399688720703,5.4070000648498535 -79.46399688720703,5.4070000648498535 C-80.78700256347656,6.171000003814697 -81.5459976196289,7.255000114440918 -81.5459976196289,8.383000373840332 C-81.5459976196289,8.40999984741211 -81.53500366210938,8.437000274658203 -81.53500366210938,8.46399974822998 C-81.53500366210938,8.479999542236328 -81.54299926757812,8.493000030517578 -81.54299926757812,8.508000373840332 C-81.54299926757812,8.508000373840332 -81.54100036621094,18.23200035095215 -81.54100036621094,18.23200035095215 C-81.60800170898438,19.283000946044922 -81.01899719238281,20.246999740600586 -79.9280014038086,20.878000259399414 C-79.9280014038086,20.878000259399414 -26.18600082397461,51.90599822998047 -26.18600082397461,51.90599822998047 C-25.284000396728516,52.426998138427734 -24.101999282836914,52.683998107910156 -22.871999740600586,52.683998107910156 C-21.430999755859375,52.683998107910156 -19.92300033569336,52.33000183105469 -18.722999572753906,51.63800048828125 C-18.722999572753906,51.63800048828125 79.46499633789062,-5.051000118255615 79.46499633789062,-5.051000118255615 C80.75199890136719,-5.794000148773193 81.48999786376953,-6.808000087738037 81.54499816894531,-7.953999996185303 C81.54499816894531,-7.953999996185303 81.54499816894531,-18.011999130249023 81.54499816894531,-18.011999130249023 C81.54499816894531,-18.020000457763672 81.5469970703125,-18.027999877929688 81.5469970703125,-18.035999298095703 C81.5469970703125,-18.040000915527344 81.54499816894531,-18.045000076293945 81.54499816894531,-18.048999786376953z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,28.909000396728516,83.47699737548828)">
                                <path fill="rgb(227,233,247)" fill-opacity="1"
                                    d=" M26.6200008392334,17.238000869750977 C26.6200008392334,17.238000869750977 26.6200008392334,14.157999992370605 26.6200008392334,14.157999992370605 C26.6200008392334,12.371999740600586 25.66699981689453,10.722000122070312 24.1200008392334,9.82800006866455 C24.1200008392334,9.82800006866455 -23.5939998626709,-17.719999313354492 -23.5939998626709,-17.719999313354492 C-24.927000045776367,-18.48900032043457 -26.5939998626709,-17.527000427246094 -26.5939998626709,-15.987000465393066 C-26.5939998626709,-15.987000465393066 -26.5939998626709,-12.248000144958496 -26.5939998626709,-12.248000144958496 C-26.618999481201172,-11.824000358581543 -26.219999313354492,-11.53600025177002 -25.979000091552734,-11.39799976348877 C-25.979000091552734,-11.39799976348877 25.1200008392334,18.104000091552734 25.1200008392334,18.104000091552734 C25.78700065612793,18.48900032043457 26.6200008392334,18.007999420166016 26.6200008392334,17.238000869750977z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,59.266998291015625,99.572998046875)">
                                <path fill="rgb(227,233,247)" fill-opacity="1"
                                    d=" M0.5849999785423279,3.984999895095825 C1.253999948501587,3.9010000228881836 1.7380000352859497,3.2980000972747803 1.7380000352859497,2.622999906539917 C1.7380000352859497,2.622999906539917 1.7380000352859497,-2.6110000610351562 1.7380000352859497,-2.6110000610351562 C1.7380000352859497,-3.3959999084472656 1.0820000171661377,-4.043000221252441 0.29899999499320984,-3.9860000610351562 C0.10499999672174454,-3.9719998836517334 -0.08799999952316284,-3.9639999866485596 -0.2809999883174896,-3.9639999866485596 C-0.2809999883174896,-3.9639999866485596 -0.29600000381469727,-3.9639999866485596 -0.29600000381469727,-3.9639999866485596 C-1.0829999446868896,-3.9660000801086426 -1.7389999628067017,-3.372999906539917 -1.7389999628067017,-2.5869998931884766 C-1.7389999628067017,-2.5869998931884766 -1.7389999628067017,2.6530001163482666 -1.7389999628067017,2.6530001163482666 C-1.7389999628067017,3.4100000858306885 -1.13100004196167,4.0269999504089355 -0.375,4.039000034332275 C-0.375,4.039000034332275 -0.3659999966621399,4.039000034332275 -0.3659999966621399,4.039000034332275 C-0.05299999937415123,4.043000221252441 0.2669999897480011,4.025000095367432 0.5849999785423279,3.984999895095825z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,112.2040023803711,70.33799743652344)">
                                <path fill="rgb(227,233,247)" fill-opacity="1"
                                    d=" M46.15800094604492,-30.753000259399414 C46.15800094604492,-30.753000259399414 33.4010009765625,-23.38800048828125 33.4010009765625,-23.38800048828125 C32.922000885009766,-23.11199951171875 32.310001373291016,-23.277000427246094 32.03499984741211,-23.7549991607666 C32.03499984741211,-23.7549991607666 28.427000045776367,-21.67099952697754 28.427000045776367,-21.67099952697754 C28.702999114990234,-21.19300079345703 28.540000915527344,-20.582000732421875 28.06100082397461,-20.305999755859375 C28.06100082397461,-20.305999755859375 26.020000457763672,-19.12700080871582 26.020000457763672,-19.12700080871582 C25.863000869750977,-19.035999298095703 25.690000534057617,-18.993000030517578 25.520999908447266,-18.993000030517578 C25.176000595092773,-18.993000030517578 24.84000015258789,-19.172000885009766 24.65399932861328,-19.493000030517578 C24.65399932861328,-19.493000030517578 22.815000534057617,-18.430999755859375 22.815000534057617,-18.430999755859375 C23.091999053955078,-17.952999114990234 22.92799949645996,-17.340999603271484 22.448999404907227,-17.065000534057617 C22.448999404907227,-17.065000534057617 -47.74700164794922,23.46299934387207 -47.74700164794922,23.46299934387207 C-48.654998779296875,24.21500015258789 -49.20000076293945,25.336000442504883 -49.20000076293945,26.538000106811523 C-49.20000076293945,26.538000106811523 -49.20000076293945,30.26799964904785 -49.20000076293945,30.26799964904785 C-49.20000076293945,31.038000106811523 -48.36600112915039,31.51799964904785 -47.70000076293945,31.134000778198242 C-47.70000076293945,31.134000778198242 48.11800003051758,-24.18600082397461 48.11800003051758,-24.18600082397461 C48.893001556396484,-24.634000778198242 49.185001373291016,-25.110000610351562 49.19900131225586,-25.4060001373291 C49.19900131225586,-25.4060001373291 49.15800094604492,-29.04400062561035 49.15800094604492,-29.04400062561035 C49.13999938964844,-30.572999954223633 47.483001708984375,-31.517000198364258 46.15800094604492,-30.753000259399414z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,81.85700225830078,48.108001708984375)">
                                <path fill="rgb(227,233,247)" fill-opacity="1"
                                    d=" M55.36800003051758,1.3700000047683716 C55.36800003051758,1.3700000047683716 57.409000396728516,0.19099999964237213 57.409000396728516,0.19099999964237213 C57.887001037597656,-0.08799999952316284 58.499000549316406,0.07900000363588333 58.77399826049805,0.5569999814033508 C58.77399826049805,0.5569999814033508 58.77399826049805,0.5590000152587891 58.77399826049805,0.5590000152587891 C58.77399826049805,0.5590000152587891 62.382999420166016,-1.524999976158142 62.382999420166016,-1.524999976158142 C62.314998626708984,-1.659999966621399 62.277000427246094,-1.7829999923706055 62.25699996948242,-1.8980000019073486 C62.25699996948242,-1.8980000019073486 62.25699996948242,-1.9129999876022339 62.25699996948242,-1.9129999876022339 C62.23500061035156,-2.0510001182556152 62.249000549316406,-2.171999931335449 62.28200149536133,-2.2839999198913574 C62.28200149536133,-2.2839999198913574 62.28300094604492,-2.2850000858306885 62.28300094604492,-2.2850000858306885 C62.310001373291016,-2.378999948501587 62.35200119018555,-2.4639999866485596 62.409000396728516,-2.5420000553131104 C62.49300003051758,-2.680000066757202 62.5989990234375,-2.803999900817871 62.749000549316406,-2.8910000324249268 C62.749000549316406,-2.8910000324249268 62.893001556396484,-2.9749999046325684 62.893001556396484,-2.9749999046325684 C63.06100082397461,-3.0820000171661377 63.236000061035156,-3.1730000972747803 63.382999420166016,-3.257999897003174 C63.382999420166016,-3.257999897003174 78.46600341796875,-11.96500015258789 78.46600341796875,-11.96500015258789 C79.25700378417969,-12.420999526977539 79.54100036621094,-12.901000022888184 79.5459976196289,-13.20199966430664 C79.5459976196289,-13.20199966430664 79.5459976196289,-13.217000007629395 79.5459976196289,-13.217000007629395 C79.54000091552734,-13.5600004196167 79.15799713134766,-13.833000183105469 78.93000030517578,-13.96500015258789 C78.93000030517578,-13.96500015258789 25.187999725341797,-44.99300003051758 25.187999725341797,-44.99300003051758 C23.833999633789062,-45.77399826049805 21.332000732421875,-45.652000427246094 19.724000930786133,-44.724998474121094 C19.724000930786133,-44.724998474121094 -78.46299743652344,11.96399974822998 -78.46299743652344,11.96399974822998 C-79.26100158691406,12.425000190734863 -79.5459976196289,12.907999992370605 -79.5459976196289,13.208000183105469 C-79.5459976196289,13.553999900817871 -79.15799713134766,13.829999923706055 -78.927001953125,13.96399974822998 C-78.927001953125,13.96399974822998 -25.18600082397461,44.9900016784668 -25.18600082397461,44.9900016784668 C-23.829999923706055,45.77299880981445 -21.327999114990234,45.650001525878906 -19.722000122070312,44.722999572753906 C-19.722000122070312,44.722999572753906 51.797000885009766,3.431999921798706 51.797000885009766,3.431999921798706 C52.27299880981445,3.1559998989105225 52.887001037597656,3.319999933242798 53.16299819946289,3.7980000972747803 C53.16299819946289,3.7980000972747803 55.00199890136719,2.7360000610351562 55.00199890136719,2.7360000610351562 C54.724998474121094,2.257999897003174 54.888999938964844,1.6460000276565552 55.36800003051758,1.3700000047683716z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,81.05000305175781,48.48500061035156)">
                                <path fill="rgb(31,33,36)" fill-opacity="1"
                                    d=" M64.05699920654297,-11.71399974822998 C64.05699920654297,-11.71399974822998 19.44300079345703,-37.47100067138672 19.44300079345703,-37.47100067138672 C18.209999084472656,-38.183998107910156 16.677000045776367,-38.18299865722656 15.442999839782715,-37.47100067138672 C15.442999839782715,-37.47100067138672 -64.05500030517578,8.428000450134277 -64.05500030517578,8.428000450134277 C-64.68199920654297,8.788999557495117 -65.05699920654297,9.435999870300293 -65.05699920654297,10.15999984741211 C-65.05699920654297,10.883000373840332 -64.68299865722656,11.529999732971191 -64.05699920654297,11.890999794006348 C-64.05699920654297,11.890999794006348 -19.44300079345703,37.64899826049805 -19.44300079345703,37.64899826049805 C-18.826000213623047,38.005001068115234 -18.134000778198242,38.183998107910156 -17.44300079345703,38.183998107910156 C-16.75200080871582,38.183998107910156 -16.059999465942383,38.005001068115234 -15.442999839782715,37.64899826049805 C-15.442999839782715,37.64899826049805 64.05699920654297,-8.24899959564209 64.05699920654297,-8.24899959564209 C64.68299865722656,-8.609999656677246 65.05699920654297,-9.258999824523926 65.05699920654297,-9.982000350952148 C65.05699920654297,-10.704999923706055 64.68299865722656,-11.35200023651123 64.05699920654297,-11.71399974822998z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,81.05000305175781,48.61899948120117)">
                                <path fill="rgb(118,134,177)" fill-opacity="1"
                                    d=" M60.05699920654297,-11.847000122070312 C60.05699920654297,-11.847000122070312 18.44300079345703,-35.87200164794922 18.44300079345703,-35.87200164794922 C18.44300079345703,-35.87200164794922 18.44300079345703,-35.87300109863281 18.44300079345703,-35.87300109863281 C18.134000778198242,-36.05099868774414 17.788000106811523,-36.13999938964844 17.44300079345703,-36.13999938964844 C17.097000122070312,-36.13999938964844 16.750999450683594,-36.05099868774414 16.44300079345703,-35.87300109863281 C16.44300079345703,-35.87300109863281 -60.05699920654297,8.293999671936035 -60.05699920654297,8.293999671936035 C-61.38999938964844,9.064000129699707 -61.38999938964844,10.98799991607666 -60.05699920654297,11.758000373840332 C-60.05699920654297,11.758000373840332 -18.44300079345703,35.784000396728516 -18.44300079345703,35.784000396728516 C-17.82699966430664,36.13999938964844 -17.05900001525879,36.13999938964844 -16.44300079345703,35.784000396728516 C-16.44300079345703,35.784000396728516 60.05699920654297,-8.383000373840332 60.05699920654297,-8.383000373840332 C61.38999938964844,-9.152999877929688 61.38999938964844,-11.07699966430664 60.05699920654297,-11.847000122070312z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,138.7449951171875,49.68299865722656)">
                                <path fill="rgb(31,33,36)" fill-opacity="1"
                                    d=" M1.8869999647140503,-1.0169999599456787 C1.6119999885559082,-1.4950000047683716 0.9980000257492065,-1.6619999408721924 0.5210000276565552,-1.3830000162124634 C0.5210000276565552,-1.3830000162124634 -1.5199999809265137,-0.20399999618530273 -1.5199999809265137,-0.20399999618530273 C-1.9989999532699585,0.07199999690055847 -2.1619999408721924,0.6840000152587891 -1.8849999904632568,1.1619999408721924 C-1.7000000476837158,1.4830000400543213 -1.3650000095367432,1.6619999408721924 -1.0190000534057617,1.6619999408721924 C-0.8500000238418579,1.6619999408721924 -0.6769999861717224,1.61899995803833 -0.5199999809265137,1.5269999504089355 C-0.5199999809265137,1.5269999504089355 1.5210000276565552,0.3490000069141388 1.5210000276565552,0.3490000069141388 C1.9989999532699585,0.0729999989271164 2.1630001068115234,-0.5379999876022339 1.8869999647140503,-1.0169999599456787z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,127.9020004272461,20.8799991607666)">
                                <path fill="rgb(31,33,36)" fill-opacity="1"
                                    d=" M-5.695000171661377,-2.062000036239624 C-5.695000171661377,-2.062000036239624 4.697999954223633,3.937999963760376 4.697999954223633,3.937999963760376 C4.855000019073486,4.0289998054504395 5.0269999504089355,4.072000026702881 5.197000026702881,4.072000026702881 C5.541999816894531,4.072000026702881 5.877999782562256,3.8929998874664307 6.064000129699707,3.572000026702881 C6.339000225067139,3.0929999351501465 6.176000118255615,2.4820001125335693 5.697999954223633,2.2060000896453857 C5.697999954223633,2.2060000896453857 -4.695000171661377,-3.7939999103546143 -4.695000171661377,-3.7939999103546143 C-5.175000190734863,-4.071000099182129 -5.785999774932861,-3.9070000648498535 -6.060999870300293,-3.427999973297119 C-6.3379998207092285,-2.950000047683716 -6.173999786376953,-2.3380000591278076 -5.695000171661377,-2.062000036239624z">
                                </path>
                            </g>
                            <g opacity="1" transform="matrix(1,0,0,1,119.23300170898438,15.87600040435791)">
                                <path fill="rgb(31,33,36)" fill-opacity="1"
                                    d=" M-0.5090000033378601,0.9300000071525574 C-0.5090000033378601,0.9300000071525574 -0.5,0.9350000023841858 -0.5,0.9350000023841858 C-0.34200000762939453,1.027999997138977 -0.16899999976158142,1.0729999542236328 0.003000000026077032,1.0729999542236328 C0.3449999988079071,1.0729999542236328 0.6779999732971191,0.8949999809265137 0.8640000224113464,0.5770000219345093 C1.1440000534057617,0.10100000351667404 0.9810000061988831,-0.5139999985694885 0.5049999952316284,-0.7940000295639038 C0.028999999165534973,-1.0729999542236328 -0.5839999914169312,-0.9150000214576721 -0.8629999756813049,-0.4390000104904175 C-1.1440000534057617,0.03700000047683716 -0.9850000143051147,0.6499999761581421 -0.5090000033378601,0.9300000071525574z">
                                </path>
                            </g>
                        </g>
                        <g style="display: none;">
                            <g>
                                <path></path>
                            </g>
                        </g>
                        <g clip-path="url(#__lottie_element_57)" filter="url(#__lottie_element_59)"
                            style="display: none;">
                            <g clip-path="url(#__lottie_element_82)" style="display: none;">
                                <g style="display: none;">
                                    <g>
                                        <path stroke-linecap="round" stroke-linejoin="round" fill-opacity="0">
                                        </path>
                                    </g>
                                </g>
                            </g>
                            <g clip-path="url(#__lottie_element_75)" style="display: none;">
                                <g style="display: none;">
                                    <g>
                                        <path stroke-linecap="round" stroke-linejoin="round" fill-opacity="0">
                                        </path>
                                    </g>
                                </g>
                            </g>
                            <g clip-path="url(#__lottie_element_68)" style="display: none;">
                                <g style="display: none;">
                                    <g>
                                        <path stroke-linecap="round" stroke-linejoin="round" fill-opacity="0">
                                        </path>
                                    </g>
                                </g>
                            </g>
                            <g clip-path="url(#__lottie_element_61)" style="display: none;">
                                <g style="display: none;">
                                    <g>
                                        <path stroke-linecap="round" stroke-linejoin="round" fill-opacity="0">
                                        </path>
                                    </g>
                                </g>
                            </g>
                        </g>
                        <g clip-path="url(#__lottie_element_25)" filter="url(#__lottie_element_27)"
                            style="display: none;">
                            <g clip-path="url(#__lottie_element_50)" style="display: none;">
                                <g style="display: none;">
                                    <g>
                                        <path stroke-linecap="round" stroke-linejoin="round" fill-opacity="0">
                                        </path>
                                    </g>
                                </g>
                            </g>
                            <g clip-path="url(#__lottie_element_43)" style="display: none;">
                                <g style="display: none;">
                                    <g>
                                        <path stroke-linecap="round" stroke-linejoin="round" fill-opacity="0">
                                        </path>
                                    </g>
                                </g>
                            </g>
                            <g clip-path="url(#__lottie_element_36)" style="display: none;">
                                <g style="display: none;">
                                    <g>
                                        <path stroke-linecap="round" stroke-linejoin="round" fill-opacity="0">
                                        </path>
                                    </g>
                                </g>
                            </g>
                            <g clip-path="url(#__lottie_element_29)" style="display: none;">
                                <g style="display: none;">
                                    <g>
                                        <path stroke-linecap="round" stroke-linejoin="round" fill-opacity="0">
                                        </path>
                                    </g>
                                </g>
                            </g>
                        </g>
                        <g style="display: none;">
                            <g>
                                <path></path>
                            </g>
                        </g>
                        <g style="display: none;">
                            <g>
                                <path></path>
                            </g>
                        </g>
                        <g style="display: none;">
                            <g>
                                <path></path>
                            </g>
                        </g>
                        <g style="display: none;">
                            <g>
                                <path></path>
                            </g>
                        </g>
                        <g style="display: none;">
                            <g>
                                <path></path>
                            </g>
                        </g>
                        <g style="display: none;">
                            <g>
                                <path></path>
                            </g>
                        </g>
                    </g>
                </svg>
            </div>
            <h1 class="table__changing-heading" style="margin-top:-3rem;">Enter a Phone Number</h1>
            <span class="table__changing-text">You will receive a text message with a verification
                code.<br><br>Your phone number can be used to verify <span style="font-weight: bold;">one Coffie
                    account</span>, at a time and is only used for verification and login.</span>
            <button type="button" class="table__changing-close" onclick="closeTableChange()">
                <div class="table__changing-close-icon">
                    <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                        viewBox="0 0 24 24">
                        <path fill="currentColor"
                            d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                        </path>
                    </svg>
                </div>
                <div class="side-bar__overview flex-item-col-center" onclick="closeTableChange()">
                <i class="ti-angle-left"></i>
                <span class="side-bar__overview-text">Overview</span>
            </button>
        </div>
        <form novalidate="" method="post">
            <div class="table__changing-button">
                <div class="table__changing-input-box" style="position: relative;">
                    <h5 class="table__changing-input-text">Phone Number</h5>
                    <input type="text" class="table__changing-input theme-light-black border-deprecated"
                        name="newPhoneNumber" placeholder="Enter phone number" spellcheck="false">
                    <div class="table__changing-fixed" style="position:absolute;top: 68%;transform: translateY(-50%);left: 80%;">
                        <div class="table__changing-box-button"
                            style="background-color:unset;padding:0;">
                            <input type="submit" class="table__default" value="Send">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</div>`;

var changeTable = `<div class="table__change table__change-email" style="display:none">
<div class="table__changing-overlay" style="opacity:1" onclick="closeTableChange()">
    <div class="table__changing-box" onclick="event.stopPropagation();">
        <div class="table__changing-title">
            <img src="asssets/img/mail.jpg" alt="" class="table__forget-img">
            <h1 class="table__changing-heading" style="margin-top:-7rem;">Verify email address</h1>
            <span class="table__changing-text">We'll need to verify your old email address, <span
                    style="font-weight: bold;" class="table__changing-hgl">phongnguyenhung473@gmail.com</span>, in order to change it.<a
                    href="https://www.facebook.com/RogdriguesZ/" class="table__changing-link"> Lost access to your
                    email? Contact to us</a>.</span>
            <button type="button" class="table__changing-close" onclick="closeTableChange()">
                <div class="table__changing-close-icon">
                    <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                        viewBox="0 0 24 24">
                        <path fill="currentColor"
                            d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                        </path>
                    </svg>
                </div>
                <div class="side-bar__overview flex-item-col-center" onclick="closeTableChange()">
                <i class="ti-angle-left"></i>
                <span class="side-bar__overview-text">Overview</span>
            </div>
            </button>
        </div>
        <form novalidate="" method="post">
            <div class="table__changing-box-button">
                <button type="button" class="table__changing-btn table__full-changing" onclick="closeTableChange()"><span>Cancel<span></button>
                <button type="button" class="table__changing-btn table__full-changing js-verify-code" onclick="changeUserEmail(this)">Send Verification Code</button>
            </div>
        </form>
    </div>
</div>
</div>`;

var changingEmailVerify = `<div class="table__change table__changing-email" style="display:none">
        <div class="table__changing-overlay" onclick="closeTableChange()" style="opacity:1;">
            <div class="table__changing-box" onclick="event.stopPropagation();">
                <div class="table__changing-title">
                    <h1 class="table__changing-heading">Enter code</h1>
                    <span class="table__changing-text">Check your email: we've sent you a verification code. Enter it here to verify you're really you.</span>
                    <button type="button" class="table__changing-close" onclick="closeTableChange()">
                        <div class="table__changing-close-icon">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                            viewBox="0 0 24 24">
                            <path fill="currentColor"
                            d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                            </svg>
                    </div>
                    <div class="side-bar__overview flex-item-col-center" onclick="closeTableChange()">
                    <i class="ti-angle-left"></i>
                    <span class="side-bar__overview-text">Account</span>
                </button>
                </div>
                <form action="">
                    <div class="table__changing-button">
                        <div class="table__changing-input-box">
                            <div>
                                <h5 class="table__changing-input-text">VERIFICATION CODE</h5>
                                <input type="text" class="table__changing-input" onkeypress="checkInputChangeUser(this)"
                                    onkeyup="checkInputChangeUser(this)" name="newNickName" spellcheck="false">
                                <a onclick="changeUserEmail(this)" style="display: inline-block;margin-top: 1rem;color: #53cddb;line-height: 12px;cursor:pointer" class="border-deprecated-thin js-verify-code">Didn't receive a code or it expired? Resend it.</a>
                            </div>
                        </div>
                    </div>
                    <div class="table__box-button">
                        <button type="button" class="table__changing-btn table__full-changing"
                            onclick="closeChanging()"><span>Cancel<span></button>
                        <button type="button" disabled="disabled"
                            class="table__changing-btn table__changing-submit table__full-changing js-send-code" onclick="changeUserEmail(this)">Next</button>
                    </div>
                </form>
            </div>
        </div>
    </div>`;

var settingNewEmail = `    <div class="table__change table__changing-email-verify" style="display:none;position: relative;z-index: 300;">
        <div class="table__changing-overlay" onclick="closeTableChange()" style="opacity:1;">
            <div class="table__changing-box" onclick="event.stopPropagation();">
                <div class="table__changing-title">
                    <h1 class="table__changing-heading">Enter an email address</h1>
                    <span class="table__changing-text">Enter a new email address and your existing password.</span>
                    <button type="button" class="table__changing-close" onclick="closeTableChange()">
                        <div class="table__changing-close-icon">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                                viewBox="0 0 24 24">
                                <path fill="currentColor"
                                    d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                                </path>
                            </svg>
                        </div>
                        <div class="side-bar__overview flex-item-col-center" onclick="closeTableChange()">
                        <i class="ti-angle-left"></i>
                        <span class="side-bar__overview-text">Account</span>
                    </button>
                </div>
                <form action="">
                    <div class="table__changing-button">
                        <div class="table__changing-input-box">
                            <div>
                                <h5 class="table__changing-input-text">EMAIL</h5>
                                <input type="text" class="table__changing-input" onkeypress="checkInputChangeBothUser()"
                                    onkeyup="checkInputChangeBothUser()" name="newNickName" spellcheck="false">
                            </div>
                            <div class="field-Spacer-Top-24">
                                <h5 class="table__changing-input-text">CURRENT PASSWORD</h5>
                                <input type="password" class="table__changing-input" onkeypress="checkInputChangeBothUser()"
                                    onkeyup="checkInputChangeBothUser()" name="newNickName" spellcheck="false">
                            </div>
                        </div>
                    </div>
                    <div class="table__box-button">
                        <button type="button" class="table__changing-btn table__full-changing"
                            onclick="closeChanging()"><span>Cancel<span></button>
                        <button type="button" disabled="disabled"
                            class="table__changing-btn table__changing-submit table__full-changing js-submit-email" onclick="changeUserEmail(this)">Done</button>
                    </div>
                </form>
            </div>
        </div>
    </div>`;

var fieldSetRadio = `
<h5 class="table__changing-input-text">Gender</h5>
<div class=table__changing-input-gender" style="text-align:center;-webkit-tap-highlight-color: transparent;">
<div class="table__radio-group gender">
    <input type="radio" name="gender" id="gender-male" value="Male">
    <label for="gender-male" onclick="onCheckBoxRadio(this)" style="font-size:1.3rem">
        <div class="radio" value="Male" style="border: 1px solid #426a81;"></div>
        Male
    </label>
</div>
<div class="table__radio-group gender">
    <input type="radio" name="gender" id="gender-female" value="Female">
    <label for="gender-female" onclick="onCheckBoxRadio(this)" style="font-size:1.3rem">
        <div class="radio" value="Female" style="border: 1px solid #426a81;"></div>
        Female
    </label>
</div>
<div class="table__radio-group gender">
    <input type="radio" name="gender" id="gender" value="Other">
    <label for="gender" onclick="onCheckBoxRadio(this)" style="font-size:1.3rem">
        <div class="radio" value="Other" style="border: 1px solid #426a81;"></div>
        Other
    </label>
</div>
</div>`;

var contentSignOutTableText = `<div class="table__sign-out" style="display:none;">
        <div class="table__sign-out-overlay" onclick="closeSignOut()">
            <div class="table__sign-out-box" onclick="event.stopPropagation();">
                <div class="table__sign-out-title">
                    <h2 class="table__sign-out-heading">Sign out</h2>
                </div>
                <div class="table__sign-out-body">
                    <span class="table__sign-out-description">Are you sure you want to sign out?</span>
                </div>
                <div class="table__sign-out-button">
                    <div class="table__box-button">
                        <button type="button" class="table__sign-out-btn" onclick="closeSignOut()"><span>Cancel<span></button>
                        <button class="table__sign-out-btn">
                            <a href="LogoutController">Sign out</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>`;

var contentChangingTableText = `<div class="table__changing table__content" style="display:none">
<div class="table__changing-overlay" onclick="closeChanging()" style="opacity:1;">
    <div class="table__changing-box" onclick="event.stopPropagation();">
        <div class="table__changing-title">
            <h1 class="table__changing-heading">Change your username</h1>
            <span class="table__changing-text">Please enter your new username.</span>
            <button type="button" class="table__changing-close" onclick="closeChanging()">
                <div class="table__changing-close-icon">
                    <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                        viewBox="0 0 24 24">
                        <path fill="currentColor"
                            d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                        </path>
                    </svg>
                </div>
                <div class="side-bar__overview js-side-bar__overview flex-item-col-center" onclick="closeChanging()">
                    <i class="ti-angle-left"></i>
                    <span class="side-bar__overview-text">Overview</span>
                </div>
            </button>
        </div>
        <form action="">
            <div class="table__changing-button">
                <div class="table__changing-input-box">
                    <div>
                        <h5 class="table__changing-input-text">Username</h5>
                        <input type="text" class="table__changing-input ajax__user-name" onkeypress="checkInputChangeUser(this)" onkeyup="checkInputChangeUser(this)" name="newNickName" spellcheck="false" defaultValue="Rog" value="Rog">
                    </div>
                </div>
            </div>
            <div class="table__box-button">
                <button type="button" class="table__changing-btn table__full-changing" onclick="closeChanging()"><span>Cancel<span></button>
                <button type="button" onclick="changeUser(this)" disabled="disabled" class="table__changing-btn js-button-user-name table__changing-submit table__full-changing">Save</button>
            </div>
        </form>
    </div>
</div>
</div>`;

//Login Forget
var forgetTableElement = `<div class="table__forget" style="display:none">
<div class="load" id="load" style="display:none;background-color:#433e3ead">
    <img src="asssets/img/CoffeeBruin.gif" alt="" class="load-gif" style="width:300px;position: relative;">    
    <div style="position: absolute;top: 50%;transform: translateY(185%);display:flex; align-items:center; column-gap:2rem;">
        <span class="load-text;" style="font-family: 'Gloria Hallelujah', cursive;">NOW LOADING</span>
          <div class="stage">
            <div class="dot-flashing"></div>
          </div>
    </div>
</div>
<div class="table__forget-overlay" style="opacity:1" onclick="closeForgetPassword()">
    <div class="table__changing-box" onclick="event.stopPropagation();">
        <div class="table__changing-title">
            <img src="asssets/img/mail.jpg" alt="" class="table__forget-img">
            <h1 class="table__forget-heading">Verify email address</h1>
            <span class="table__changing-text">We'll need you to enter your email so we can send a verify to get your password.</span>
            <button type="button" class="table__changing-close" onclick="closeForgetPassword()">
                <div class="table__changing-close-icon">
                    <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                        viewBox="0 0 24 24">
                        <path fill="currentColor"
                            d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                        </path>
                    </svg>
                </div>
            </button>
                <div class="side-bar__overview js-side-bar__overview flex-item-col-center" onclick="closeForgetPassword()" onclick="closeChanging()" style="font-size: 1.5rem;top: -5rem;display: flex;">
                    <i class="ti-angle-left"></i>
                    <span class="side-bar__overview-text">Overview</span>
                </div>
        </div>
        <form action="ForgetController" method="post" onsubmit="return forgetFormValidate()">
            <div class="table__changing-button">
                <div class="table__changing-input-box">
                    <div>
                        <h5 class="table__forget-input-text">Email</h5>
                        <input type="text" class="table__forget-input js-forg-email" name="email" placeholder = "E-mail address">
                    </div>
                </div>
            </div>
            <div class="table__changing-box-button">
                <button type="button" class="table__forget-btn" onclick="closeForgetPassword()">Cancel</button>
                <button type="submit" class="table__forget-btn">Send</button>
            </div>
        </form>
    </div>
</div>
</div>`;

var deleteAccountVerify = `    <div class="table__verify" style="display:none;">
        <div class="table__verify-overlay" onclick="closeVerify()" style="opacity: 1;z-index: 999;">
            <div class="table__verify-box" style="position: relative;" onclick="event.stopPropagation();">
                <div class="table__verify-title">
                    <h2 class="table__verify-heading">DELETE ACCOUNT</h2>
                    <button type="button" class="table__changing-close" onclick="closeVerify()" style="top:16px;left:unset;">
                        <div class="table__changing-close-icon" style="display:block;">
                            <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24"
                                viewBox="0 0 24 24">
                                <path fill="currentColor"
                                    d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                                </path>
                            </svg>
                        </div>
                    </button>
                </div>
                <div class="table__verify-body">
                    <span class="table__verify-description" style="font-size:1.4rem">Do you wish to delete your account?</span>
                </div>
                <div class="table__verify-button">
                    <div class="table__verify-box-button">
                        <button type="button" class="table__verify-btn" onclick="deleteUser(this)">Okay</button>
                    </div>
                </div>
            </div>
        </div>
    </div>`;

//Shopping
var buyCart = `    <div class="table__change purchase" style="display:none;">
        <div class="table__changing-overlay purchase__overlay" value="js-non-mobile" style="opacity:1;transform:translateX(0%);z-index: 280;"onclick="closeTableChange()">
            <div class="purchase__container"onclick="event.stopPropagation();">
                <button type="button" class="table__changing-close" style="top:26px;z-index:300" onclick="closeTableChange()">
                    <div class="table__changing-close-icon">
                        <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor"
                                d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                        </svg>
                    </div>
                </button>
                <div class="purchase__box">
                    <div class="purchase__header">
                        <div class="purchase__title">Purchase Item</div>
                    </div>
                    <div class="purchase__background">
                        <div class="purchase__order-information">
                            <h5 class="purchase__title-header" style="display:block">Your Order</h5>
                            <div class="purchase__body">
                                <div class="purchase__img on-img-change">
                                    <img src="asssets/img/cake1.png" alt="" class="purchase__img-item">
                                </div>
                                <div class="purchase__product flex-direction-col flex-container">
                                    <div class="purchase__product-name">Creame cake</div>
                                    <span class="purchase__product-type on-type-change">Cake</span>
                                    <div class="purchase__amount margin-top-auto">
                                        <div class="purchase__amount-action quantity">
                                            <input type="number" class="purchase__amount-input" min="1" max="99" value="1">
                                            <div class="quantity-nav"><button class="quantity-button quantity-up" onclick="onclickPrice(this)"><i
                                                        class="ti-plus"></i></button><button
                                                    class="quantity-button quantity-down"onclick="onclickPrice(this)"><i class="ti-minus"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="purchase__delivery field-Spacer-Top-24">
                            <h5 class="purchase__title-header" style="display:block">Delivery Location</h5>
                            <div class="purchase__delivery-body">
                                <div class="purchase__delivery-img">
                                    <img src="asssets/img/location.png" alt="">
                                </div>
                                <div class="purchase__delivery-address">
                                    90 Sanfoudry
                                </div>
                            </div>
                        </div>
                        <div class="purchase__price field-Spacer-Top-24 field-Spacer-Bottom-20">
                            <h5 class="purchase__title-header" style="display:block">Order Info</h5>
                            <div class="purchase__price-group">
                                <div class="purchase__price-list">
                                    <div class="purchase__sub-title">Subtotal</div>
                                    <div class="purchase__price-list-box">
                                        <div class="purchase__price-icon">$</div>
                                        <div class="purchase__price-title on-price" value="7.99">7.99</div>
                                    </div>
                                </div>
                            </div>
                            <div class="purchase__price-group" style="border-bottom: 1px solid rgb(239 218 218 / 58%);">
                                <div class="purchase__price-list">
                                    <div class="purchase__sub-title">Shipping Cost</div>
                                    <div class="purchase__price-list-box">
                                        <div class="purchase__price-icon">$</div>
                                        <div class="purchase__price-title on-ship" value="5.00">5.00</div>
                                    </div>
                                </div>
                            </div>
                            <div class="purchase__price-group" style="margin-top:1.5rem;">
                                <div class="purchase__price-list">
                                    <div class="purchase__sub-title">Total</div>
                                    <div class="purchase__price-list-box">
                                        <div class="purchase__price-icon">$</div>
                                        <div class="purchase__price-title on-total" value=""></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="purchase__submit">
                            <button type="button" class="purchase__submit-btn on-submit" onclick="onClickPurchase()">Add to cart</button>
                            <button type="button" class="purchase__submit-btn" onclick="closeTableChange()">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>`

var buyCartAccept = `    <div class="table__purchase purchase" style="display:none;">
        <div class="purchase__overlay" style="z-index: 300 !important;opacity: 0;"onclick="closePurchase()">
            <div class="purchase__container" style="width: 25rem;max-width: calc(100% - 12px);" onclick="event.stopPropagation();">
                <button type="button" class="table__changing-close" style="top:26px;z-index:250" onclick="closePurchase()">
                    <div class="table__changing-close-icon">
                        <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor"
                                d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                        </svg>
                    </div>
                </button>
                <div class="purchase__box">
                    <div class="purchase__header">
                        <div class="purchase__title">Purchase Item</div>
                    </div>
                    <div class="purchase__background">
                        <div class="purchase__body">
                            <div class="purchase__product on-sign">
                                <div class="purchase__product-name">Creame cake</div>
                                <span class="purchase__product-sub-heading">Do you want to purchase <span class="purchase__number">1</span> of this product?</span>
                            </div>
                        </div>
                        <div class="purchase__action">
                            <div class="purchase__action-btn">
                                <button type="button" class="purchase__submit-btn" style="font-size:1rem" onclick="purchaseOrder()">OK</button>
                                <img src="asssets/img/check.png" alt=""  class="purchase__action-btn-img">
                            </div>
                            <div class="purchase__action-btn">
                                <button type="button" class="purchase__submit-btn" style="font-size:1rem" onclick="closePurchase()">Cancel</button>
                                <img src="asssets/img/close.png" alt="" class="purchase__action-btn-img">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>`;

var tablePurchaseSuccess = `    <div class="table__purchase purchase purchase-accept" style="display:none;">
        <div class="purchase__overlay" style="z-index: 300 !important;opacity: 1;"onclick="closePurchase()">
            <div class="purchase__container" style="width: 25rem;max-width: calc(100% - 12px);" onclick="event.stopPropagation();">
                <button type="button" class="table__changing-close" style="top:26px;z-index:250" onclick="closePurchase()">
                    <div class="table__changing-close-icon">
                        <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor"
                                d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                        </svg>
                    </div>
                </button>
                <div class="purchase__box">
                    <div class="purchase__header">
                        <div class="purchase__title">Purchase</div>
                    </div>
                    <div class="purchase__background">
                        <div class="purchase__body">
                            <div class="purchase__product on-sign">
                                <span class="purchase__product-sub-heading">Purchase successful<br>Please check your order to track your order. </span>
                            </div>
                        </div>
                        <div class="purchase__action">
                            <div class="purchase__action-btn">
                                <button type="button" class="purchase__submit-btn" style="font-size:1rem" onclick="closePurchase()">OK</button>
                                <img src="asssets/img/check.png" alt=""  class="purchase__action-btn-img">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>`;

var optionChooseOrder = `<div class="side-bar__order-navbar">
                    <div class="side-bar__order-item active-checked checked-theme"
                         onclick="openOtherOrder(this)">
                        <span>All</span>
                        <img src="asssets/img/to-do-list.png" alt="" class="side-bar__order-show-img">
                    </div>
                    <div class="side-bar__order-item" onclick="openOtherOrder(this)">
                        <span>Process</span>
                        <img src="asssets/img/delivery.png" alt="" class="side-bar__order-show-img">
                    </div>
                    <div class="side-bar__order-item" onclick="openOtherOrder(this)">
                        <span>Completed</span>
                        <img src="asssets/img/package.png" alt="" class="side-bar__order-show-img">
                    </div>
                    <div class="side-bar__order-item" onclick="openOtherOrder(this)">
                        <span>Cancelled</span>
                        <img src="asssets/img/cancel.png" alt="" class="side-bar__order-show-img">
                    </div>
                </div>
                <div class="side-bar__order-search" style="margin-top: 1rem;">
                    <img class="side-bar__order-search-icon" src="asssets/img/search.png"
                         style="width:20px;margin-right: 1rem;" alt="">
                    <input oninput="searchByName(this)" autocomplete="off" placeholder="Find product by name" value=""
                           style="outline: none;background: none;border: none;">
                </div>`;

var cancelledMessage =`    <div class="table__purchase purchase order-cancelled" style="display: none;">
        <div class="purchase__overlay" style="opacity: 0; z-index: 300 !important;" onclick="closePurchase()">
            <div class="purchase__container" style="width: 35em;max-width: calc(100% - 12px);" onclick="event.stopPropagation();">
                <button type="button" class="table__changing-close" style="top:26px;z-index:250" onclick="closePurchase()">
                    <div class="table__changing-close-icon">
                        <svg class="closeIcon-11LhXr" aria-hidden="false" width="24" height="24" viewBox="0 0 24 24">
                            <path fill="currentColor" d="M18.4 4L12 10.4L5.6 4L4 5.6L10.4 12L4 18.4L5.6 20L12 13.6L18.4 20L20 18.4L13.6 12L20 5.6L18.4 4Z">
                            </path>
                        </svg>
                    </div>
                </button>
                <div class="purchase__box">
                    <div class="purchase__header">
                        <div class="purchase__title">Canceled Order</div>
                    </div>
                    <div class="purchase__cancelled-background">
                        <div class="purchase__body">
                            <div class="purchase__cancelled-group">
                                <h5 class="purchase__product-cancelled">Please let's we hear about your reason</h5>
                                <div class="purchase__product-cancelled-group">
                                    <div class="purchase__product-cancelled-item">
                                        <img src="asssets/img/confused.gif" alt="" style="width:60px;height: 45px;">
                                        <span class="purchase__product-cancelled-text">Please choose your reason to cancelled the order. Notice that the order wil completely cancelled and cannot be restore. </span>
                                    </div>
                                    <div class="purchase__product-cancelled-item">
                                        <input type="radio" name="cancelledDescription" id="reason-1" class="purchase__product-cancelled-input" value="Want to change delivery location first.">
                                        <label for="reason-1" class="purchase__product-cancelled-text" onclick="checkBoxInputCancelled(this)">Want to change delivery location first</label>
                                    </div>
                                    <div class="purchase__product-cancelled-item">
                                        <input type="radio" name="cancelledDescription" id="reason-2" class="purchase__product-cancelled-input" value="Want to change product in order (quantity).">
                                        <label for="reason-2" class="purchase__product-cancelled-text" onclick="checkBoxInputCancelled(this)">Want to change product in order (quantity)</label>
                                    </div>
                                    <div class="purchase__product-cancelled-item">
                                        <input type="radio" name="cancelledDescription" id="reason-3" class="purchase__product-cancelled-input" value="Find the other product that are way cheaper than current product.">
                                        <label for="reason-3" class="purchase__product-cancelled-text" onclick="checkBoxInputCancelled(this)">Find the other product that are way cheaper than current product</label>
                                    </div>
                                    <div class="purchase__product-cancelled-item">
                                        <input type="radio" name="cancelledDescription" id="reason-4" class="purchase__product-cancelled-input" value="Change one's mind, didn't want to order the product anymore.">
                                        <label for="reason-4" class="purchase__product-cancelled-text" onclick="checkBoxInputCancelled(this)">Change one's mind, didn't want to order the product anymore</label>
                                    </div>
                                    <div class="purchase__product-cancelled-item">
                                        <input type="radio" name="cancelledDescription" id="reason-5" class="purchase__product-cancelled-input" value="Other.">
                                        <label for="reason-5" class="purchase__product-cancelled-text" onclick="checkBoxInputCancelled(this)">Other</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="purchase__action">
                            <div class="purchase__action-btn">
                                <button type="button" class="purchase__submit-btn" style="font-size:1rem;background: #e6f1fa;box-shadow: 0px 4px 0px 0px #c2cfd2;" onclick="cancelOrder(this)" disabled>Cancelled Order</button>
                            </div>
                            <div class="purchase__action-btn">
                                <button type="button" class="purchase__submit-btn" style="font-size:1rem;background-color: #f0ecec;" onclick="closePurchase()">Not Now</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>`;

var cancelButton = `<button class="side-bar__order-btn-buy" onclick="onclickProduct(this)">Buy again</button>
                    <button class="side-bar__order-btn-other">Details</button>`; 


var orderDetailsSuccess =`<div class="side-bar__order-details-main" style="display:none;">
<div class="side-bar__header color-modifier">
    <div class="side-bar__title">
        <div class="side-bar__title-heading-box">
            <h1 class="side-bar__title-heading">Order Details</h1>
            <div class="side-bar__overview" onclick="closeDetails()">
                <i class="ti-angle-left"></i>
                <span class="side-bar__overview-text">Order History</span>
            </div>
        </div>
    </div>
</div>
<div class="side-bar__order-body field-Spacer-Top-10" id="side-bar__order-body">
    <div class="side-bar__details">
        <div class="side-bar__details-main-group">
            <img src="asssets/img/14pz.gif" alt="" class="side-bar__details-main-group-img">
            <div class="side-bar__details-main-box">
                <h5 class="side-bar__details-title completed">Delivering Order Successful</h5>
                <span class="side-bar__details-sub-title">Your order has been delivering successfully. If you have any problem with our product, please keep your invoice and original packaging as you would need these in the event of a return.</span>
            </div>
        </div>
        <div class="side-bar__details-group">
            <div class="side-bar__details-sub-group field-Spacer-Top-16">
                <div class="side-bar__details-group-title flex-container flex-between-center-col">
                    <div class="side-bar__details-title-box">
                        <h5 class="side-bar__details-heading">Purchase order</h5>
                        <img src="asssets/img/product.png" alt="" class="side-bar__details-img-icon">
                    </div>
                </div>
                <div class="side-bar__details-group-box">
                    <img src="asssets/img/cake1.png" alt="" class="side-bar__details-group-img">
                </div>
                <div class="flex-item-col-center flex-direction-col">
                    <h5 class="side-bar__details-product-name">Creame Cake</h5>
                    <div class="side-bar__details-product-type">Cake</div>
                </div>
                <div class="side-bar__details-group-price-list field-Spacer-Top-24">
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Price</div>
                        <div class="side-bar__details-on-price">$7.99</div>
                    </div>
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Quantity</div>
                        <div class="side-bar__details-on-quantity">x1</div>
                    </div>
                    <div class="side-bar__details-group-price" style="
                    border-bottom: 1px solid var(--border-modifier);
                    padding-bottom: 1rem;">
                        <div class="side-bar__details-price-title">Shipping cost</div>
                        <div class="side-bar__details-on-shipping">$10.00</div>
                    </div>
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Total</div>
                        <div class="side-bar__details-on-total">$7.99</div>
                    </div>
                    <div class="side-bar__details-img-rate flex-item-col-center">
                        <img src="asssets/img/star.png" alt="" style="width:30px;height:30px;">
                        <div class="side-bar__details-total-rate">0.0</div>
                        <div class="side-bar__details-total-number-rate">/ 0K</div>
                    </div>
                </div>
                <div class="side-bar__details-rate-up-description flex-justify-center">
                    Enjoy your day and rate our product.
                </div>
                <div class="side-bar__details-rate-up flex-justify-center">
                    <img src="asssets/img/no-star.png" alt="" class="star-selected one-star" onclick="rateProduct(this)">
                    <img src="asssets/img/no-star.png" alt="" class="star-selected two-star" onclick="rateProduct(this)">
                    <img src="asssets/img/no-star.png" alt="" class="star-selected three-star" onclick="rateProduct(this)">
                    <img src="asssets/img/no-star.png" alt="" class="star-selected four-star" onclick="rateProduct(this)">
                    <img src="asssets/img/no-star.png" alt="" class="star-selected five-star" onclick="rateProduct(this)">
                </div>
            </div>
            <div class="side-bar__details-sub-group on-grid-2 field-Spacer-Top-16">
                <div class="side-bar__details-address">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-title-box">
                            <h5 class="side-bar__details-heading">Delivery Location</h5>
                            <img src="asssets/img/location-1.png" alt="" class="side-bar__details-img-icon">
                        </div>
                        <div class="side-bar__details-alt-box">
                            <div class="side-bar__details-name">ROGDRIGUES</div>
                            <div class="side-bar__phone-number">0374817587</div>
                            <div class="side-bar__details-address-text">90 Sanfoudry Number As Ascalalica Kasandara</div>
                        </div>
                    </div>
                </div>
                <div class="side-bar__details-delivery-date">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-group-title">
                            <div class="side-bar__details-title-box">
                                <h5 class="side-bar__details-heading">Transport Information</h5>
                                <img src="asssets/img/delivery.png" alt="" class="side-bar__details-img-icon">
                            </div>
                            <div class="side-bar__details-alt-box">
                                <div class="side-bar__name-transport">Life of Coffie</div>
                                <div class="side-bar__details-address-text completed status bold">Delivering Successfully</div>
                                <div class="side-bar__details-order-text"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="side-bar__details-delivery-date">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-group-title">
                            <div class="side-bar__details-title-box">
                                <h5 class="side-bar__details-heading">Summary</h5>
                                <img src="asssets/img/calendar.png" alt="" class="side-bar__details-img-icon">
                            </div>
                            <div class="side-bar__details-alt-box">
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__details-name">Order ID</div>
                                    <div class="side-bar__details-order-id id-success">223456</div>
                                </div>
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__phone-name">Order Time</div>
                                    <div class="side-bar__details-order-time">05-07-2022 10:08</div>
                                </div>
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__details-name">Completed Time</div>
                                    <div class="side-bar__details-order-completed">05-07-2022 10:08</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <div class="side-bar__details-close" onclick="closeDetails()">
        <img src="asssets/img/back-button.png" alt="" style="width:50px;height:50px;">
    <span>Back to Order History</span>
    </div>
</div>`;

var orderDetailsCancelled =`<div class="side-bar__order-details-main" style="display:none;">
<div class="side-bar__header color-modifier">
    <div class="side-bar__title">
        <div class="side-bar__title-heading-box">
            <h1 class="side-bar__title-heading">Order Details</h1>
            <div class="side-bar__overview" onclick="closeDetails()">
                <i class="ti-angle-left"></i>
                <span class="side-bar__overview-text">Order History</span>
            </div>
        </div>
    </div>
</div>
<div class="side-bar__order-body field-Spacer-Top-10" id="side-bar__order-body">
    <div class="side-bar__details">
        <div class="side-bar__details-main-group">
            <img src="asssets/img/cat-sleeping.gif" alt="" class="side-bar__details-main-group-img">
            <div class="side-bar__details-main-box">
                <h5 class="side-bar__details-title cancelled">Delivering Order is
                    cancelled</h5>
                <span class="side-bar__details-sub-title">Your order has been cancelled
                    due to your action. If your order was not cancelled completely, you
                    can contact to us.</span>
            </div>
        </div>
        <div class="side-bar__details-group">
            <div class="side-bar__details-sub-group field-Spacer-Top-16">
                <div class="side-bar__details-group-title flex-container flex-between-center-col">
                    <div class="side-bar__details-title-box">
                        <h5 class="side-bar__details-heading">Purchase order</h5>
                        <img src="asssets/img/product.png" alt="" class="side-bar__details-img-icon">
                    </div>
                </div>
                <div class="side-bar__details-group-box">
                    <img src="asssets/img/cake1.png" alt="" class="side-bar__details-group-img">
                </div>
                <div class="flex-item-col-center flex-direction-col">
                    <h5 class="side-bar__details-product-name">Creame Cake</h5>
                    <div class="side-bar__details-product-type">Cake</div>
                </div>
                <div class="side-bar__details-group-price-list field-Spacer-Top-24">
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Price</div>
                        <div class="side-bar__details-on-price">$7.99</div>
                    </div>
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Quantity</div>
                        <div class="side-bar__details-on-quantity">x1</div>
                    </div>
                    <div class="side-bar__details-group-price" style="
                    border-bottom: 1px solid var(--border-modifier);
                    padding-bottom: 1rem;">
                        <div class="side-bar__details-price-title">Shipping cost</div>
                        <div class="side-bar__details-on-shipping">$10.00</div>
                    </div>
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Total</div>
                        <div class="side-bar__details-on-total">$7.99</div>
                    </div>
                    <div class="side-bar__details-img-rate flex-item-col-center">
                        <img src="asssets/img/star.png" alt="" style="width:30px;height:30px;">
                        <div class="side-bar__details-total-rate">0.0</div>
                        <div class="side-bar__details-total-number-rate">/ 0K</div>
                    </div>
                </div>
            </div>
            <div class="side-bar__details-sub-group on-grid-2 field-Spacer-Top-16">
                <div class="side-bar__details-address">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-title-box">
                            <h5 class="side-bar__details-heading">Delivery Location</h5>
                            <img src="asssets/img/location-1.png" alt="" class="side-bar__details-img-icon">
                        </div>
                        <div class="side-bar__details-alt-box">
                            <div class="side-bar__details-name">ROGDRIGUES</div>
                            <div class="side-bar__phone-number">0374817587</div>
                            <div class="side-bar__details-address-text">90 Sanfoudry Number As Ascalalica Kasandara</div>
                        </div>
                    </div>
                </div>
                <div class="side-bar__details-delivery-date">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-group-title">
                            <div class="side-bar__details-title-box">
                                <h5 class="side-bar__details-heading">Transport Information</h5>
                                <img src="asssets/img/delivery.png" alt="" class="side-bar__details-img-icon">
                            </div>
                            <div class="side-bar__details-alt-box">
                                <div class="side-bar__name-transport">Life of Coffie</div>
                                <div class="side-bar__details-address-text cancelled status bold">Delivering Failed</div>
                                <div class="side-bar__details-description-text on-cancelled">Reason: [Reason go here]</div>
                                <div class="side-bar__details-order-text"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="side-bar__details-delivery-date">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-group-title">
                            <div class="side-bar__details-title-box">
                                <h5 class="side-bar__details-heading">Summary</h5>
                                <img src="asssets/img/calendar.png" alt="" class="side-bar__details-img-icon">
                            </div>
                            <div class="side-bar__details-alt-box">
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__details-name">Order ID</div>
                                    <div class="side-bar__details-order-id id-cancelled">223456</div>
                                </div>
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__phone-name">Order Time</div>
                                    <div class="side-bar__details-order-time">05-07-2022 10:08</div>
                                </div>
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__details-name">Cancelled Time</div>
                                    <div class="side-bar__details-order-cancelled">05-07-2022 10:08</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <div class="side-bar__details-close" onclick="closeDetails()">
        <img src="asssets/img/back-button.png" alt="" style="width:50px;height:50px;">
    <span>Back to Order History</span>
    </div>
</div>`;

var detailsDelayed =`    <div class="side-bar__order-details-main" style="display:none;">
<div class="side-bar__header color-modifier">
    <div class="side-bar__title">
        <div class="side-bar__title-heading-box">
            <h1 class="side-bar__title-heading">Order Details</h1>
            <div class="side-bar__overview" onclick="closeDetails()">
                <i class="ti-angle-left"></i>
                <span class="side-bar__overview-text">Order History</span>
            </div>
        </div>
    </div>
</div>
<div class="side-bar__order-body field-Spacer-Top-10" id="side-bar__order-body">
    <div class="side-bar__details">
        <div class="side-bar__details-main-group">
            <img src="asssets/img/14pz.gif" alt="" class="side-bar__details-main-group-img">
            <div class="side-bar__details-main-box">
                <h5 class="side-bar__details-title delayed">Delivering Order Delayed</h5>
                <span class="side-bar__details-sub-title">Your order has been delayed due to some incident. Don't worry, we'll try our best to bring our product to you. Hope you understand.</span>
            </div>
        </div>
        <div class="side-bar__details-group">
            <div class="side-bar__details-sub-group field-Spacer-Top-16">
                <div class="side-bar__details-group-title flex-container flex-between-center-col">
                    <div class="side-bar__details-title-box">
                        <h5 class="side-bar__details-heading">Purchase order</h5>
                        <img src="asssets/img/product.png" alt="" class="side-bar__details-img-icon">
                    </div>
                </div>
                <div class="side-bar__details-group-box">
                    <img src="asssets/img/cake1.png" alt="" class="side-bar__details-group-img">
                </div>
                <div class="flex-item-col-center flex-direction-col">
                    <h5 class="side-bar__details-product-name">Creame Cake</h5>
                    <div class="side-bar__details-product-type">Cake</div>
                </div>
                <div class="side-bar__details-group-price-list field-Spacer-Top-24">
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Price</div>
                        <div class="side-bar__details-on-price">$7.99</div>
                    </div>
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Quantity</div>
                        <div class="side-bar__details-on-quantity">x1</div>
                    </div>
                    <div class="side-bar__details-group-price" style="
                    border-bottom: 1px solid var(--border-modifier);
                    padding-bottom: 1rem;">
                        <div class="side-bar__details-price-title">Shipping cost</div>
                        <div class="side-bar__details-on-shipping">$10.00</div>
                    </div>
                    <div class="side-bar__details-group-price">
                        <div class="side-bar__details-price-title">Total</div>
                        <div class="side-bar__details-on-total">$7.99</div>
                    </div>
                    <div class="side-bar__details-img-rate flex-item-col-center">
                        <img src="asssets/img/star.png" alt="" style="width:30px;height:30px;">
                        <div class="side-bar__details-total-rate">4.5</div>
                        <div class="side-bar__details-total-number-rate">/ 62K</div>
                    </div>
                </div>
            </div>
            <div class="side-bar__details-sub-group on-grid-2 field-Spacer-Top-16">
                <div class="side-bar__details-address">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-title-box">
                            <h5 class="side-bar__details-heading">Delivery Location</h5>
                            <img src="asssets/img/location-1.png" alt="" class="side-bar__details-img-icon">
                        </div>
                        <div class="side-bar__details-alt-box">
                            <div class="side-bar__details-name">ROGDRIGUES</div>
                            <div class="side-bar__phone-number">0374817587</div>
                            <div class="side-bar__details-address-text">90 Sanfoudry Number As Ascalalica Kasandara</div>
                        </div>
                    </div>
                </div>
                <div class="side-bar__details-delivery-date">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-group-title">
                            <div class="side-bar__details-title-box">
                                <h5 class="side-bar__details-heading">Transport Information</h5>
                                <img src="asssets/img/delivery.png" alt="" class="side-bar__details-img-icon">
                            </div>
                            <div class="side-bar__details-alt-box">
                                <div class="side-bar__name-transport">Life of Coffie</div>
                                <div class="side-bar__details-address-text delayed status bold">Delivering Delayed</div>
                                <div class="side-bar__details-description-text on-delayed">Reason: [Reason go here]</div>
                                <div class="side-bar__details-order-text"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="side-bar__details-delivery-date">
                    <div class="side-bar__details-group-title">
                        <div class="side-bar__details-group-title">
                            <div class="side-bar__details-title-box">
                                <h5 class="side-bar__details-heading">Summary</h5>
                                <img src="asssets/img/calendar.png" alt="" class="side-bar__details-img-icon">
                            </div>
                            <div class="side-bar__details-alt-box">
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__details-name">Order ID</div>
                                    <div class="side-bar__details-order-id id-delayed">223456</div>
                                </div>
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__phone-name">Order Time</div>
                                    <div class="side-bar__details-order-time">05-07-2022 10:08</div>
                                </div>
                                <div class="flex-item-col-center flex-between-center-col">
                                    <div class="side-bar__details-name">Delayed Time</div>
                                    <div class="side-bar__details-order-delayed">05-07-2022 10:08</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <div class="side-bar__details-close" onclick="closeDetails()">
        <img src="asssets/img/back-button.png" alt="" style="width:50px;height:50px;">
    <span>Back to Order History</span>
    </div>
</div>
</div>`;

var tableBodyContent = `<table>
<thead>
    <tr>
        <th>Product</th>
        <th>Price</th>
        <th>Total</th>
        <th>Status</th>
    </tr>
</thead>
<tbody class="side-bar__table-body-overwrite">
</tbody>
</table>`;