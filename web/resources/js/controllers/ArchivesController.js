
var ArchivesController = function ($scope, $interval, $http, $timeout) {

    $scope.fetchArchivesList = function () {
        $http.get('/archivesList.json').
            success(function (data) {
                $scope.archivesList = data.archivesVOList;
                $scope.articleList = data.archivesVOList[0].articleInfoVOList;
            }).
            error(function (err) {
                console.log(err);
            });
    };

    initializeArchives();
    initializeLoad($scope, $timeout);
    $scope.fetchArchivesList();
};

/**
 * 初始化
 */
function initializeArchives() {
    $(".menu_bar ul li").each(function (index) {
        if(index == 1) {
            $(this).addClass("active");
        }else {
            $(this).removeClass("active");
        }
    });

    $(document).attr("title","归档 | Pelin的个人博客");
}