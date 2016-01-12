/**
 * Copyright 2016 IBM Corp. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
function useSampleText() {
  $.ajax({
    url: "js/sample.txt",
    dataType: "text",
    success: function (data) {
      $('#analysis-description').val("Reflection - Gandhi");
      $('#analysis-text').val(data);
    }
  });
}

$("#create-analysis").submit(function (event) {
  console.log("Submitting new analysis...");
  event.preventDefault();

  $("#analysis-submit").prop("disabled", true);
  $("#analysis-submit-loader").show();

  var form = $(this);
  $.ajax({
    type: "POST",
    url: "api/pi",
    data: form.serialize()
  }).done(function (data) {
    console.info("Submit success!");
    getEntries();
  }).fail(function (data) {
    console.error("Submit failed!");
  }).always(function (data) {
    $("#analysis-submit-loader").hide();
    $("#analysis-submit").prop("disabled", false);
  });
});

function getEntries() {
  var entriesContainer = $("#entries");
  entriesContainer.text("");

  $("#entries-loader").show();

  $.ajax({
    type: "GET",
    url: "api/pi"
  }).done(function (data) {
    console.info("Received", data);

    data.forEach(function (entry) {
      entriesContainer.append(template({
        entry: entry
      }));
    });

  }).fail(function (data) {
    console.error(data);
  }).always(function (data) {
    $("#entries-loader").hide();
  });
}

function deleteEntry(id) {
  console.info("Deleting entry", id);
  $.ajax({
    type: "DELETE",
    url: "api/pi/" + id
  }).done(function (data) {
    console.info("Entry", id, "deleted");
    $("#entry-" + id).remove();
  }).fail(function (data) {
    console.error(data);
  });
}

var source = $("#entry-template").html();
var template = Handlebars.compile(source);
Handlebars.registerHelper('formatPercent', function (value) {
  return Math.round(value * 100);
});
Handlebars.registerHelper('truncate', function (text, length) {
  if (!text || text.length <= length) {
    return text;
  } else {
    return text.substring(0, length) + "...";
  }
});

getEntries();
