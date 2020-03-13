</body>
 <script type="text/javascript" language="javascript">
     function dateFmatter(cellvalue, options, rowObject) {
         if (cellvalue == '' || cellvalue == null) {
             return "";
         }
         var date = new Date(cellvalue);
         var mm = date.getMonth();
         var datetime = date.getFullYear() + "-"// "年"
                 + ((date.getMonth() + 1) >= 10 ? (date.getMonth() + 1) : ("0" + (date.getMonth() + 1))) + "-"// "月"
                 + (date.getDate() < 10 ? "0" + date.getDate() : date
                         .getDate()) + " "
                 + (date.getHours() < 10 ? "0" + date.getHours() : date
                         .getHours()) + ":"
                 + (date.getMinutes() < 10 ? "0" + date.getMinutes() : date
                         .getMinutes()) + ":"
                 + (date.getSeconds() < 10 ? "0" + date.getSeconds() : date
                         .getSeconds());
         return datetime;
     }
 </script>
</html>